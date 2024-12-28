package Pages;
import org.jspecify.annotations.*;
import org.openqa.selenium.*;

public class MainPage {

    By continueButtonLocator = By.xpath("//*[@id=\"pay-connection\"]/button");
    By serviceDetailsLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");
    By phoneLocator = By.id("connection-phone");
    By sumLocator = By.id("connection-sum");


    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        if(!"МТС – мобильный оператор в Беларуси".equals(driver.getTitle())) {
            throw new IllegalStateException("Страница не \"МТС – мобильный оператор в Беларуси\"");
        }
    }

    public MainPage BlockPayCashOut(String phone, String sum) {
        driver.findElement(phoneLocator).sendKeys(phone);
        driver.findElement(sumLocator).sendKeys(sum);
        driver.findElement(continueButtonLocator).click();
        return this;
    }


    public MainPage BlockPayServiceDetails() {
        driver.findElement(serviceDetailsLocator).click();
        return this;
    }

    public @Nullable String getTitle() {
        driver.getTitle();
        return driver.getTitle();
    }
}
