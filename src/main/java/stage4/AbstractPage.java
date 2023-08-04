package lesson6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;
//    private JavascriptExecutor js;


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
//        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return this.driver;

    }
}
