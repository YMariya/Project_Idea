package Selenium.Task_2;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import Task_2.ChoosePolicyPage;
import Task_2.MainPage;
import Task_2.RegistrationPage;
import Task_2.TravelInsurancePage;

/**
 *  Create by Yakovleva Mariya
 */
public class MyRefactoringTest extends BaseTest {
    @Test
    public void newInsuranceTest() {
        //Перейти в меню страхование путешественников
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        MainPage subMenu = new MainPage(driver);
        subMenu.selectSubMenu(driver);

        //Проверить заголовок
        TravelInsurancePage getTitle = new TravelInsurancePage(driver);
        getTitle.title.getText();
        Assert.assertEquals("Отсутствует заголовок Страхование путешественников", "Страхование путешественников", getTitle.title.getText());
        //Нажать на кнопку Оформить
        new TravelInsurancePage(driver).sendButton.click();
        //Переключаемся на страницу
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //Выбираем минимальную сумму и нажимаем кнопку Оформить
        new ChoosePolicyPage(driver).minSum.click();
        new ChoosePolicyPage(driver).formalizeButton.click();
        //Заполняем форму
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.filledData("Фамилия застрахованного", "IVANOV");
        registrationPage.filledData("Имя застрахованного", "IVAN");
        registrationPage.filledData("Дата рождения застрахованного", "01012011");
        registrationPage.filledData("Фамилия страхователя", "Стрыкова");
        registrationPage.filledData("Имя страхователя", "Валентина");
        registrationPage.filledData("Отчество страхователя", "Петровна");
        registrationPage.filledData("Дата рождения страхователя", "13021980");
        registrationPage.filledData("Пол страхователя", "");
        registrationPage.filledData("Серия паспорта", "1234");
        registrationPage.filledData("Номер паспорта", "567899");
        registrationPage.filledData("Дата выдачи паспорта", "12022001");
        registrationPage.filledData("Кем выдан", "ОУФМС ОВД по г. Москва");
        //Проверяем введенные поля
        RegistrationPage checkField = new RegistrationPage(driver);
        checkField.checkField("Фамилия застрахованного");
        checkField.checkField("Имя застрахованного");
        checkField.checkField("Дата рождения застрахованного");
        checkField.checkField("Фамилия страхователя");
        checkField.checkField("Имя страхователя");
        checkField.checkField("Отчество страхователя");
        checkField.checkField("Дата рождения страхователя");
        checkField.checkField("Пол страхователя");
        checkField.checkField("Серия паспорта");
        checkField.checkField("Номер паспорта");
        checkField.checkField("Дата выдачи паспорта");
        checkField.checkField("Кем выдан");
        //Нажимаем на кнопку продолжить
        RegistrationPage clickButtonNext = new RegistrationPage(driver);
        clickButtonNext.clickButton();
        //Проверить сообщение о ошибке
        clickButtonNext.checkMassegeError();
    }
}