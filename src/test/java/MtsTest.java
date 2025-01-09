import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import Pages.MainPage;

import java.time.Duration;
import java.util.*;

public class MtsTest {

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    static boolean isCookieAppeared = false;
    static boolean failSafeTriggered = false;
    MainPage mainPage = new MainPage(driver);

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
    @Description("Проверка работоспособности блока оплаты и текста в нём и окне ввода карты")
    @Severity(SeverityLevel.CRITICAL)
    public void mtsBlockPayBaPaidIsDisplayedWithCorrectFieldsTest() {
        //Get data for a test, pass it to pageObject to fill and apply
        String sum ="20";
        mainPage.BlockPayCashOut("297777777", sum);
        Double i = Double.parseDouble(sum);
        sum = String.format(Locale.US,"%.2f", i);
        //Waiting for new frame to open, asserting that frame is present
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app")));
        WebElement cardConfirmWindow = driver.findElement(By.className("bepaid-app"));
        Assertions.assertTrue(cardConfirmWindow.isDisplayed()); //BePaid is present

        //Switch to BePaidIframe, test all fields
        WebElement bePaidIframe = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
        driver.switchTo().frame(bePaidIframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header__close-button"))); //waiting to frame to be full loaded
        WebElement sumDisplayed = driver.findElement(By.className("pay-description__cost"));
        Assertions.assertEquals( sum + " BYN", sumDisplayed.getText());
        WebElement payButton = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
        Assertions.assertEquals("Оплатить "+ sum +" BYN",payButton.getText());
        WebElement cardBrands = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div"));
        Assertions.assertTrue(cardBrands.isDisplayed());
        WebElement cvcPlaceHolder = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]"));
        Assertions.assertEquals("CVC", cvcPlaceHolder.getText());
        WebElement numberCardField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]"));
        Assertions.assertEquals("Номер карты", numberCardField.getText());
        WebElement expirationDateField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]"));
        Assertions.assertEquals("Срок действия", expirationDateField.getText());
        WebElement holderNameField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]"));
        Assertions.assertEquals("Имя держателя (как на карте)", holderNameField.getText());
        WebElement closeBepaid = driver.findElement(By.className("header__close-button"));
        closeBepaid.click();
        driver.switchTo().defaultContent();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void mtsBlockPayDropDownFieldsCorrectTextTest() {
        // Услуги связи
        WebElement connectionPhone = driver.findElement(By.id("connection-phone"));
        Assertions.assertEquals("Номер телефона", connectionPhone.getAttribute("placeholder"));
        WebElement connectionSum = driver.findElement(By.id("connection-sum"));
        Assertions.assertEquals("Сумма", connectionSum.getAttribute("placeholder"));
        WebElement connectionEmail = driver.findElement(By.id("connection-email"));
        Assertions.assertEquals("E-mail для отправки чека", connectionEmail.getAttribute("placeholder"));
        // Домашний интернет
        WebElement internetPhone = driver.findElement(By.id("internet-phone"));
        Assertions.assertEquals("Номер абонента", internetPhone.getAttribute("placeholder"));
        WebElement internetSum = driver.findElement(By.id("internet-sum"));
        Assertions.assertEquals("Сумма", internetSum.getAttribute("placeholder"));
        WebElement internetEmail = driver.findElement(By.id("internet-email"));
        Assertions.assertEquals("E-mail для отправки чека", internetEmail.getAttribute("placeholder"));
        //Рассрочка
        WebElement scoreInstalmnent = driver.findElement(By.id("score-instalment"));
        Assertions.assertEquals("Номер счета на 44", scoreInstalmnent.getAttribute("placeholder"));
        WebElement sumInstalmnent = driver.findElement(By.id("instalment-sum"));
        Assertions.assertEquals("Сумма", sumInstalmnent.getAttribute("placeholder"));
        WebElement instalmentEmail = driver.findElement(By.id("instalment-email"));
        Assertions.assertEquals("E-mail для отправки чека", instalmentEmail.getAttribute("placeholder"));
        //Задолженность
        WebElement scoreArrears = driver.findElement(By.id("score-arrears"));
        Assertions.assertEquals("Номер счета на 2073", scoreArrears.getAttribute("placeholder"));
        WebElement sumArrears = driver.findElement(By.id("arrears-sum"));
        Assertions.assertEquals("Сумма", sumArrears.getAttribute("placeholder"));
        WebElement ArrearsEmail = driver.findElement(By.id("arrears-email"));
        Assertions.assertEquals("E-mail для отправки чека", ArrearsEmail.getAttribute("placeholder"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void mtsBlockPayServiceDetailsTest() {
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей",mainPage.BlockPayServiceDetails().getTitle());
        driver.navigate().back();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void mtsBlockPayNameTest() {
        WebElement blockPay = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", blockPay.getText());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void mtsBlockPayPartnersLogosTest() {
        String[] logosAttributes = new String[]{"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        int picker = 0;
        WebElement partnersBankLogos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
        List<WebElement> images = partnersBankLogos.findElements(By.tagName("img"));
        for (WebElement image : images) {
            String name = image.getAttribute("alt");
            Assertions.assertEquals(name, logosAttributes[picker]);
            picker++;
        }
    }

    @AfterAll
    static public void tearDown() {
        driver.quit();
    }
}
