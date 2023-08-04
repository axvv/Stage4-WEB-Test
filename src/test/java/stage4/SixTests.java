package stage4;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SixTests extends AbstractTest {
    @Test
    @DisplayName("Тест авторизации на сайте test-stand")
    @Description("Тест  заполняет поле Username и Password и кликает на кнопку Login. Выполняется проверка элемента авторизации на странице.")
    @Link("https://test-stand.gb.ru/login")
    @Severity(SeverityLevel.NORMAL)
//    test-1
    void mainAuthorizationTest() throws InterruptedException {
        TStandLoginPage tStandLoginPage = new TStandLoginPage(getWebDriver());
        tStandLoginPage
                .enterPlaceUsername()
                .enterPlacePassword()
                .clickButtonLogin();

        // проверяем, что на странице есть элемент авторизации пользователя
         Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//*[@class=\"user-menu__name\"]")), "Элемент не найден на странице");
    }

}