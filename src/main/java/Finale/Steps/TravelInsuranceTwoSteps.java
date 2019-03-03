package Finale.Steps;

import ru.yandex.qatools.allure.annotations.Step;
import java.util.HashMap;
import Finale.Page.TravelInsuranceTwoStep;
public class TravelInsuranceTwoSteps{

    @Step("Выбран тип гражданства - {0}")
    public void stepChooseCitizenship (String citizenornot) {
        new TravelInsuranceTwoStep(BaseSteps.getDriver()).chooseCitezenship(citizenornot);
    }

    @Step("Выбран пол - {0}")
    public void stepChooseGender (String gender) {
        new TravelInsuranceTwoStep(BaseSteps.getDriver()).chooseGender(gender);
    }

    @Step("Поле {0} заполнено значением - {1}")
    public void stepFillField (String field, String value) {
        new TravelInsuranceTwoStep(BaseSteps.getDriver()).fillOurPainFields(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillAllFields (HashMap<String,String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Поле - {0} - имеет значение - {1}")
    public void stepCheckField (String fieldToCheck, String expectedValue) {
        new TravelInsuranceTwoStep(BaseSteps.getDriver()).checkThemPay(fieldToCheck, expectedValue);
    }

    @Step("Проверка всех полей")
    public void stepCheckAllFields (HashMap<String,String> fields) {
        fields.forEach(this::stepCheckField);
    }

    @Step("Нажата кнопка - Продолжить")
    public void stepContinueButtonClick () {
        new TravelInsuranceTwoStep(BaseSteps.getDriver()).continueButton.click();
    }

    @Step("Сообщение об ошибке соответствует шаблону - Заполнены не все обязательные поля")
    public void stepCheckErrorMessage (String errorMessage) {
        new TravelInsuranceTwoStep(BaseSteps.getDriver()).checkErrorMessage(errorMessage);
    }
}