package stage4;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class StandUITests extends AbstractTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data-full.csv")
    @DisplayName("Тест авторизации на сайте test-stand")
    @Description("Тест  заполняет поле Username и Password и кликает на кнопку Login. Выполняется проверка перехода на страницу постов.Выход из аккаунта.")
    @Link("https://test-stand.gb.ru/login")
    @Severity(SeverityLevel.NORMAL)
//    test-1
    void mainAuthorizationTest(String username, String password) throws InterruptedException {
        TStandLoginPage tStandLoginPage = new TStandLoginPage(getWebDriver());
        tStandLoginPage
                .enterPlaceUsername(username)
                .enterPlacePassword(password)
                .clickButtonLogin();

        // проверяем, что перешли на страницу постов
        Assertions.assertEquals((getWebDriver().findElement(By.xpath("//h1"))).getText(), "Blog");
        //        пауза
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // проверяем, что на странице есть элемент авторизации
        Assertions.assertEquals((getWebDriver().findElement(By.xpath("//li[3]/a"))).getText(), "Hello, " + username);
//         разлогиниваемся
        tStandLoginPage
                .clickButtonHello()
                .clickButtonLogout();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data-cut.csv")
    @DisplayName("Тест находит страницы без постов")
    @Description("Тест проверяет количество постов на странице моих постов.Выход из аккаунта.")
    @Link("https://test-stand.gb.ru/login")
    @Severity(SeverityLevel.NORMAL)
//    test-2
    void mainMePostsEmptyTest(String username, String password) throws InterruptedException {
        TStandLoginPage tStandLoginPage = new TStandLoginPage(getWebDriver());
        tStandLoginPage
                .enterPlaceUsername(username)
                .enterPlacePassword(password)
                .clickButtonLogin();
        // проверяем, что страница не содержит постов (пустая)
        Assertions.assertFalse(getWebDriver().findElements(By.xpath("//h2")).size() > 0, "Заголовок h2 найден");
//         разлогиниваемся
        tStandLoginPage
                .clickButtonHello()
                .clickButtonLogout();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data-cut.csv")
    @DisplayName("Тест находит страницы с постами и проверяет состав поста")
    @Description("Тест проверяет состав поста (изображение, название и описание).Выход из аккаунта.")
    @Link("https://test-stand.gb.ru/login")
    @Severity(SeverityLevel.NORMAL)
//    test-3
    void mainMePostsPartsTest(String username, String password) throws InterruptedException {
        TStandLoginPage tStandLoginPage = new TStandLoginPage(getWebDriver());
        tStandLoginPage
                .enterPlaceUsername(username)
                .enterPlacePassword(password)
                .clickButtonLogin()
//                переход в пост, если он есть на странице
                .clickTitlePost();
// проверяем, что есть изображение в посте
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//img")), "Элемент не найден на странице");
// проверяем, что есть название поста
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//h1")), "Элемент не найден на странице");
        // проверяем, что есть описание поста
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//h2")), "Элемент не найден на странице");
//         разлогиниваемся
        tStandLoginPage
                .clickButtonHello()
                .clickButtonLogout();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data-cut.csv")
    @DisplayName("Тест проверяет корректность перехода Previous Page и Next Page на странице моих постов")
    @Description("Тест находит кнопки Previous Page и Next Page, проверяет переходы между страницами и состояние тумблера Not Me и сортировки постов.Выход из аккаунта.")
    @Link("https://test-stand.gb.ru/login")
    @Severity(SeverityLevel.NORMAL)
//    test-4
    void mainMePostsSerfTest(String username, String password) throws InterruptedException {
        TStandLoginPage tStandLoginPage = new TStandLoginPage(getWebDriver());
        tStandLoginPage
                .enterPlaceUsername(username)
                .enterPlacePassword(password)
                .clickButtonLogin()
                // клик на кнопку Next Page - 2раза
                .clickNextButton()
                .clickNextButton();
// проверяем, что есть кнопка Next Page
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//a[contains(text(),'Next Page')]")), "Элемент не найден на странице");
        tStandLoginPage
                .scrollUpPage();
        // проверяем состояние тумблера Not Me
        Assertions.assertNotNull(getWebDriver().findElement(By.cssSelector(".mdc-switch__icon--off")), "Элемент не найден на странице");
        // проверяем состояние сортировки постов
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//*[@class='material-icons mdc-icon-button__icon mdc-icon-button__icon--on' and @aria-hidden='true']")), "Элемент не найден на странице");
        // клик на кнопку Previous Page- 2 раза
        tStandLoginPage
                .clickPrevButton()
                .clickPrevButton();
        // проверяем, что есть задизейблиная кнопка Previous Page
        Assertions.assertNotNull(getWebDriver().findElement(By.cssSelector(".disabled")), "Элемент не найден на странице");
//         разлогиниваемся
        tStandLoginPage
                .clickButtonHello()
                .clickButtonLogout();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data-cut.csv")
    @DisplayName("Тест проверяет корректность перехода Previous Page и Next Page на странице чужих постов")
    @Description("Тест находит кнопки Previous Page и Next Page, проверяет переходы между страницами и состояние тумблера Not Me и сортировки постов.Выход из аккаунта.")
    @Link("https://test-stand.gb.ru/login")
    @Severity(SeverityLevel.NORMAL)
        //    test-5
    void mainNotMePostsSerfTest(String username, String password) throws InterruptedException {
        TStandLoginPage tStandLoginPage = new TStandLoginPage(getWebDriver());
        tStandLoginPage
                .enterPlaceUsername(username)
                .enterPlacePassword(password)
                .clickButtonLogin()
                .clickNotMeSelector()
//                переход в пост, если он есть на странице
                .clickTitlePost()
                // клик на кнопку Next Page - 2раза
                .clickNextButton()
                .clickNextButton();

// проверяем, что есть кнопка Next Page
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//a[contains(text(),'Next Page')]")), "Элемент не найден на странице");
        tStandLoginPage
                .scrollUpPage();
        // проверяем состояние тумблера Not Me
        Assertions.assertNotNull(getWebDriver().findElement(By.cssSelector(".mdc-switch__icon--off")), "Элемент не найден на странице");
        // проверяем состояние сортировки постов
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//*[@class='material-icons mdc-icon-button__icon mdc-icon-button__icon--on' and @aria-hidden='true']")), "Элемент не найден на странице");
        // клик на кнопку Previous Page- 2 раза
        tStandLoginPage
                .clickPrevButton()
                .clickPrevButton();
        // проверяем, что есть задизейблиная кнопка Previous Page
        Assertions.assertNotNull(getWebDriver().findElement(By.cssSelector(".disabled")), "Элемент не найден на странице");
//         разлогиниваемся
        tStandLoginPage
                .clickButtonHello()
                .clickButtonLogout();
    }

    @Test
    @DisplayName("Логи браузера")
    @Description("Создаем логи")
    @Link("https://test-stand.gb.ru/login")
    @Severity(SeverityLevel.MINOR)
    void testLogs() {
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
        }
    }
}