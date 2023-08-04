package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class SixTests extends AbstractTest {
    @Test
//    test-1
    void mainAboutProjectTest() throws InterruptedException {
//      клик по кнопке О проекте
        WebElement webElement = driver.findElement(By.cssSelector(".menu-link"));
        webElement.click();
        //        перемещаемся вниз на 4000 пикселей
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,4000);");
//        пауза
        Thread.sleep(500);
        //      клик по кнопке Показать больше вопросов
        WebElement webElement2 = driver.findElement(By.xpath("//*[@class=\"js-more-about-faq button-line_gray\"]"));
        webElement2.click();
        // проверяем, что открылась требуемая страница
        Assertions.assertEquals("Помощь путешественникам", driver.getTitle(), "Не та страница");
    }

    @Test
        //    test-2
    void mainAuthorizationTest() throws InterruptedException {
        //      клик по кнопке Войти
        WebElement webElement1 = driver.findElement(By.cssSelector("*[data-test=\"login-link\"]"));
        webElement1.click();
        //      клик по кнопке email
        WebElement webElement2 = driver.findElement(By.cssSelector("*[data-test=\"email\"]"));
        webElement2.click();
        //      клик по кнопке email
        WebElement webElement3 = driver.findElement(By.cssSelector("*[data-test=\"email\"]"));
        webElement3.sendKeys("agbmu@mailto.plus");
        //      клик по кнопке пароль
        WebElement webElement4 = driver.findElement(By.cssSelector("*[data-test=\"password\"]"));
        webElement4.sendKeys("XXC922XX");
//      клик по чекбоксу - 2 раза
        WebElement webElement5 = driver.findElement(By.xpath("//*[@class='checkbox']"));
        webElement5.click();
        webElement5.click();
//      клик по кнопке отправить
        WebElement webElement6 = driver.findElement(By.cssSelector("*[data-test=\"submit\"]"));
        webElement6.click();
        // проверяем, что пользователь вошел в систему

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class=\"user-menu__name\"]")) != null, "Элемент не найден на странице");
    }

    @Test
        //    test-3
    void mainSelectFavoriteTest() throws InterruptedException {
        //        перемещаемся вниз на 700 пикселей
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,700);");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        выбираем направление тура

        WebElement webElement1 = driver.findElement(By.xpath("//*[@data-test=\"destinations\"]"));

        webElement1.click();


//        выбираем из списка Калугу
        WebElement webElement2 = driver.findElement(By.xpath("//a[contains(text(),'Калуга')]"));
        webElement2.click();

//        перемещаемся вниз на 314 пикселей

        js.executeScript("window.scrollTo(0,314);");

//        выбираем экскурсию
        WebElement webElement3 = driver.findElement(By.cssSelector(".swiper-slide-next .header use"));
        webElement3.click();
//      перемещаемся в начало страницы и пауза
        js.executeScript("window.scrollTo(0,0);");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      клик по иконке Избранное на слайде
        WebElement webElement4 = driver.findElement(By.cssSelector(".favorites .icon use"));
        webElement4.click();
//      клик по иконке Избранное в хедере
        WebElement webElement5 = driver.findElement(By.cssSelector(".city:nth-child(1) .header use"));
        webElement5.click();

// проверяем, что в избранном пусто

        Assertions.assertTrue(null != driver.findElement(By.xpath("//*[@class=\"description\"][contains(text(),\"пока пуст\")]")), "Элемент не найден на странице");
    }

    @Test
        //    test-4
    void mainSurfingReviewsTest() throws InterruptedException {
        //        перемещаемся вниз на 4000 пикселей
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,4000);");
//        пауза
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      клик по кнопке Вперёд слайдера отзывов
        WebElement webElement1 = driver.findElement(By.cssSelector(".welcome-reviews-slider > .slick-next > svg"));

        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
//      клик по кнопке Назад слайдера отзывов
        WebElement webElement2 = driver.findElement(By.cssSelector(".welcome-reviews-slider > .slick-prev > svg"));

        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();
// проверяем, что открыт нужный блок
        Assertions.assertTrue(null != driver.findElement(By.xpath(" //*[@class=\"welcome-title\"][contains(text(),'Отзывы путешественников')]")), "Элемент не найден на странице");

    }

    @Test
        //    test-5
    void mainBecomeGuideTest() throws InterruptedException {
        //      скролл на 4000 вниз
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,4000);");
        //        пауза
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement1 = driver.findElement(By.cssSelector(".welcome-howitworks-block:nth-child(1) .azure-link"));
        webElement1.click();
        //      клик по кнопке Предложить экскурсию
        //      скролл на 5500 вниз
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollTo(0,5500);");
        //        пауза
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement2 = driver.findElement(By.cssSelector(".white-line .new-button_green"));
        webElement2.click();
        //      клик по кнопке Отправить
        WebElement webElement3 = driver.findElement(By.cssSelector(".js-submit-btn"));
        webElement3.click();

        // проверяем, что открыта страница Регистрация
        Assertions.assertEquals("Регистрация",driver.getTitle(),"Не та страница");
    }
    @Test
        //    test-6
    void mainJumpToForbsTest() throws InterruptedException {
        //      скролл на 3500 вниз
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollTo(0,3500);");
        //        пауза
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        клик по иконке Forbs
        WebElement webElement1 = driver.findElement(By.cssSelector(".welcome-press-block:nth-child(2) > .welcome-press-block__img"));
        webElement1.click();
// Получаем текущий идентификатор окна
        String currentWindowHandle = driver.getWindowHandle();

// Получаем список идентификаторов всех открытых окон
        Set<String> allWindowHandles = driver.getWindowHandles();

// Проходим по списку идентификаторов и переключаемся на окно Forbs
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // проверяем, что открыта страница Forbs
        Assertions.assertEquals("Нестандартный маршрут: как сервис Tripster зарабатывает на гидах-любителях | Forbes.ru",driver.getTitle(),"Не та страница");
    }
}

