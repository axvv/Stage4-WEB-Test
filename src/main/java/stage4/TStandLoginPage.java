package stage4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class TestStandLoginPage extends AbstractPage {
    private JavascriptExecutor js;


    @FindBy(xpath = "//input[@type='text']")
    private WebElement placeUsername;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement placePassword;

    @FindBy(xpath = "//form[@id='login']/div[3]/button")
    private WebElement buttonLogin;


    public TestStandLoginPage(WebDriver driver) {
        super(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public TestStandLoginPage clickButtonEnter() {
        //      клик по кнопке Войти
        buttonEnter.click();
        return this;
    }

    public TestStandLoginPage clickPlaceEmail() {
        //      клик по полю email
        placeUsername.click();
        return this;
    }

    public TestStandLoginPage enterPlaceUsername() {
        //      ввод значения Username в поле Username
        placeUsername.sendKeys("112user");
        return this;
    }

    public TestStandLoginPage enterPlacePassword() {
        //      ввод пароля в поле password
        placePassword.sendKeys("74ece1c259");
        return this;
    }


    public TestStandLoginPage clickButtonLogin() {
        //      клик по кнопке Отправить
        buttonLogin.click();
        return this;
    }


}
