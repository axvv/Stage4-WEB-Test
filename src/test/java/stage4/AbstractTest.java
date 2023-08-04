package lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    public static WebDriver driver;



    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow(() -> driver.get("https://experience.tripster.ru"),
                "Страница не доступна");
    }


    @AfterAll
    static void close() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

