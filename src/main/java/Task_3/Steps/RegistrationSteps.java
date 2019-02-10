package Task_3.Steps;

import org.openqa.selenium.WebElement;
import Task_3.Page.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Yakovleva M.V.
 */
public class RegistrationSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String fieldName, String value) {
        new RegistrationPage(driver).filledData(fieldName, value);
    }

    //чтобы у нас все поля заполнились
    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value) {

        String actual = new RegistrationPage(driver).getCheckField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }


    @Step("Поля заполнены верно:")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> stepCheckFillField(k, v));
    }

    @Step("Пол заполнен верно")
    public void stepCheckMale(WebElement female){
        new RegistrationPage(driver).female.click();
        assertTrue("Неверно заполнен пол", female.isSelected());
    }


    @Step("Выполнено нажатие на кнопку - Продолжить")
    public void stepClickButtonNextReg() {
        new RegistrationPage(driver).nextReg.click();
    }

    @Step("Выполнена проверка наличия ошибки на странице")
    public void stepCheckMassegeError(String expecteErrorMassage) {
        String actualErrorMassage = new RegistrationPage(driver).errorMassage.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualErrorMassage, expecteErrorMassage), expecteErrorMassage, actualErrorMassage);
    }

}
