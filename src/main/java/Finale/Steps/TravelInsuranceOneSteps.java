package Finale.Steps;

import Finale.Page.TravelInsuranceOneStep;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;


public class TravelInsuranceOneSteps{


    @Step("Загрузилась страница для выбора суммы страховки")
    public void stepWaitElements (){
        new TravelInsuranceOneStep(BaseSteps.getDriver()).waitElements();
    }

    @Step("Выбрана сумма страховки - {0}")
    public void stepSelectInsuranceSum (String insuranceSum) {
        new TravelInsuranceOneStep(BaseSteps.getDriver()).selectInsurance(insuranceSum);
    }

    @Step("Нажата кнопка - Оформить")
    public void stepAcceptButtonClick () {
        new TravelInsuranceOneStep(BaseSteps.getDriver()).acceptButton.click();
    }
}