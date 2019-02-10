package Selenium.Task_3;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import Task_3.Steps.*;
import java.util.HashMap;


public class AllureTest extends BaseSteps {
    MainSteps mainPageSteps = new MainSteps();
    HashMap<String, String> testData = new HashMap<>();

    @Test
    @Title("Оформление страхования")
    public void Test(){
        MainSteps mainSteps = new MainSteps();
        TravelInsuranceSteps travelInsuranceSteps =new TravelInsuranceSteps();
        ChoosePolicySteps choosePolicySteps = new ChoosePolicySteps();
        RegistrationSteps registrationSteps = new RegistrationSteps();

        HashMap<String, String> testData = new HashMap<>();

        testData.put("Фамилия застрахованного", "IVANOV");
        testData.put("Имя застрахованного", "LEV");
        testData.put("Дата рождения застрахованного", "01.01.2011");
        testData.put("Фамилия страхователя", "Иванова");
        testData.put("Имя страхователя", "Елена");
        testData.put("Отчество страхователя", "Петровна");
        testData.put("Дата рождения страхователя", "02.02.1984");
        testData.put("Пол страхователя","");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "567890");
        testData.put("Дата выдачи паспорта", "12.02.2010");
        testData.put("Кем выдан", "Отделением ОВД по г. Москва");

        mainSteps.stepSelectMainMenu("Застраховать");
        mainSteps.setSelectSubMenu();

        travelInsuranceSteps.stepCheckTitle("Страхование путешественников");
        travelInsuranceSteps.stepSendButton();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        choosePolicySteps.stepChooseMinSum();
        choosePolicySteps.stepClickFormalizeButton();

        registrationSteps.stepFillFields(testData);

        registrationSteps.checkFillFields(testData);


        registrationSteps.stepClickButtonNextReg();
        registrationSteps.stepCheckMassegeError("Заполнены не все обязательные поля");
    }
}