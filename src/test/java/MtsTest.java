import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MtsTest {

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    static boolean isCookieAppeared = false;
    static boolean failSafeTriggered = false;

    /*
        If the cookie acceptance popup does not appear after loading the main page, it will not appear no matter how much time you wait, causing various problems,
        it is likely that it will appear after navigating to another page or returning to the main page.
        Offsetting isCookieAppeared to true on next appearance, even if accepted it will appear again and again, or not, its rare, and show yourself like once on 10-20 runs
        Sometimes is cookie acceptance is not visible, but still present on the page, and prevents clicking on anything
        And, of course, it will break the tests without catching it with ElementClickInterceptedException, exception
        will tell clicking was intercepted by "shop", if not catch it will give ElementClickInterceptedException on clicking continueButton "Продолжить" and tell it was intercepted by "cookie show"
    */

    public static void AcceptCookies(){
        if(!isCookieAppeared){
            try{
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cookie-agree\"]")));
                WebElement cookieAgree = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
                cookieAgree.click();
                isCookieAppeared = true;
            }
            catch (TimeoutException e){
                System.out.println("Timeout, cookie agreement isn`t appeared.");
                failSafeTriggered = true;
            }
            catch (ElementClickInterceptedException e){
                System.out.println("Click was intercepted");
            }
        }
        System.out.println(isCookieAppeared);
    }

    @BeforeAll
    public static void setUp() {
        driver.get("https://www.mts.by/");
        AcceptCookies();
    }

    @BeforeEach
    public void testsWillNeverBreakBecauseCookie() {
        if(failSafeTriggered){
            isCookieAppeared = false;
            AcceptCookies();
        }
    }

    @Test
    public void mtsBlockPayIsWorkingTest() {
        Map<String, String> formData = new HashMap<>();
        formData.put("phone", "297777777");
        formData.put("sum", "20");
        driver.findElement(By.id("connection-phone")).sendKeys(formData.get("phone"));
        driver.findElement(By.id("connection-sum")).sendKeys(formData.get("sum"));

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app")));
        WebElement cardConfirmWindow = driver.findElement(By.className("bepaid-app"));
        assert cardConfirmWindow.isDisplayed();
    }

    @Test
    public void mtsBlockPayServiceDetailsTest() {
        WebElement serviceDetails = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        serviceDetails.click();
        assert (Objects.equals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей"));
        driver.navigate().back();
    }

    @Test
    public void mtsBlockPayNameTest() {
        WebElement blockPay = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String name = blockPay.getText();
        assert name.equals("Онлайн пополнение\n" + "без комиссии");
    }

    @Test
    public void mtsBlockPayPartnersLogosTest() {
        String[] logosAttributes = new String[]{"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        int picker = 0;
        WebElement partnersBankLogos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
        List<WebElement> images = partnersBankLogos.findElements(By.tagName("img"));
        for (WebElement image : images) {
            String name = image.getAttribute("alt");
            assert Objects.equals(name, logosAttributes[picker]);
            picker++;
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
