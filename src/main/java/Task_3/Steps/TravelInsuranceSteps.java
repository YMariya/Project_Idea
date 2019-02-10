package Task_3.Steps;

import Task_3.Page.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.*;

/**
 * Yakovleva M.V.
 */
public class TravelInsuranceSteps extends BaseSteps {

    @Step("Выполнена проверка наличия на странице заголовка - Страхование путешественников")
    public void stepCheckTitle(String expectedTitle) {
        String actualTitle = new TravelInsurancePage(driver).title.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), expectedTitle, actualTitle);
    }

    @Step("Выполнено нажатие на кнопку - Оформить Онлайн")
    public void stepSendButton() {
        new TravelInsurancePage(driver).sendButton.click();
    }
}