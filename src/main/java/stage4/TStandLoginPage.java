package stage4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TStandLoginPage extends AbstractPage {
    private JavascriptExecutor js;


    @FindBy(xpath = "//input[@type='text']")
    private WebElement placeUsername;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement placePassword;

    @FindBy(xpath = "//form[@id='login']/div[3]/button")
    private WebElement buttonLogin;
    @FindBy(xpath = "//li[3]/a")
    private WebElement buttonHello;
    @FindBy(xpath = "//li[3]/span[2]")
    private WebElement buttonLogout;
    @FindBy(xpath = "//h2")
    private WebElement titlePost;
    @FindBy(xpath = "//a[contains(text(),'Previous Page')]")
    private WebElement prevButton;
    @FindBy(xpath = "//a[contains(text(),'Next Page')]")
    private WebElement nextButton;
    @FindBy(css = ".mdc-switch__icon--off")
    private WebElement notMeSelector;

    public TStandLoginPage(WebDriver driver) {
        super(driver);
        this.js = (JavascriptExecutor) driver;
    }


    public TStandLoginPage clickPlaceEmail() {
        //      клик по полю email
        placeUsername.click();
        return this;
    }

    public TStandLoginPage enterPlaceUsername(String username) {
        //      ввод значения Username в поле Username
        if (username != null) {
            placeUsername.sendKeys("" + username);
        }
        return this;
    }

    public TStandLoginPage enterPlacePassword(String password) {
        //      ввод пароля в поле password
        if (password != null) {
            placePassword.sendKeys("" + password);
        }
        return this;
    }


    public TStandLoginPage clickButtonLogin() {
        //      клик по кнопке Отправить
        buttonLogin.click();
        return this;
    }

    public TStandLoginPage clickButtonHello() {
        //      клик по кнопке Hello
        buttonHello.click();
        return this;
    }

    public TStandLoginPage clickButtonLogout() {
        //      клик по кнопке Logout
        buttonLogout.click();
        return this;
    }

    public TStandLoginPage clickTitlePost() {
        //      клик по заголовку поста
        titlePost.click();
        return this;
    }
    public TStandLoginPage clickPrevButton() {
        //      клик по кнопке Previous Page
        prevButton.click();
        return this;
    }
    public TStandLoginPage clickNextButton() {
        //      клик по кнопке Next Page
        nextButton.click();
        return this;
    }
    public TStandLoginPage clickNotMeSelector() {
        //      клик по селектору Not Ne
        notMeSelector.click();
        return this;
    }

    public TStandLoginPage scrollDownPage() throws InterruptedException {
        // перемещаемся вниз
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //        пауза
        Thread.sleep(1000);
        return this;
    }

    public TStandLoginPage scrollUpPage()throws InterruptedException {
        // перемещаемся вверх
        js.executeScript("window.scrollTo(0, 0);");
        //        пауза
        Thread.sleep(1000);
        return this;
    }
}
