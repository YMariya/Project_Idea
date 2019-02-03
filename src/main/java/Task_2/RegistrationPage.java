package Task_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 *  Create by Yakovleva Mariya
 */
public class RegistrationPage {

    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(name = "female")
    WebElement female;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passportNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//span[text()='Продолжить']")
    WebElement nextReg;

    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    WebElement errorMassage;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        // (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(title));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        wait.until(ExpectedConditions.visibilityOf(nextReg));
    }

    public void clickButton() {
        nextReg.click();
    }

    public void checkMassegeError() {
        assertEquals("Отсутствует сообщение об ошибке", "Заполнены не все обязательные поля", errorMassage.getText());
    }

    public void filledData(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                filledData(insuredSurname, value);
                break;
            case "Имя застрахованного":
                filledData(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                filledData(insuredBirthDate, value);
                break;
            case "Фамилия страхователя":
                filledData(surname, value);
                break;
            case "Имя страхователя":
                filledData(name, value);
                break;
            case "Отчество страхователя":
                filledData(middlename, value);
                break;
            case "Дата рождения страхователя":
                birthDate.click();
                filledData(birthDate, value);
                break;
            case "Пол страхователя":
                female.click();
                break;
            case "Серия паспорта":
                filledData(passportSeries, value);
                break;
            case "Номер паспорта":
                filledData(passportNumber, value);
                break;
            case "Дата выдачи паспорта":
                filledData(issueDate, value);
                break;
            case "Кем выдан":
                filledData(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");

        }
    }

    //Метод для заполнения полей
    public void filledData(WebElement element, String value) {
        element.clear();//очищаем поле перед заполнением
        element.sendKeys(value);//заполнение
    }

    public void checkField(String checkFieldName) {
        switch (checkFieldName) {
            case "Фамилия застрахованного":
                assertEquals("Неверно заполнено поле", "IVANOV", insuredSurname.getAttribute("value"));
                break;
            case "Имя застрахованного":
                assertEquals("Неверно заполнено поле", "IVAN", insuredName.getAttribute("value"));
                break;
            case "Дата рождения застрахованного":
                assertEquals("Неверно заполнено поле", "01.01.2011", insuredBirthDate.getAttribute("value"));
                break;
            case "Фамилия страхователя":
                assertEquals("Неверно заполнено поле", "Стрыкова", surname.getAttribute("value"));
                break;
            case "Имя страхователя":
                assertEquals("Неверно заполнено поле", "Валентина", name.getAttribute("value"));
                break;
            case "Отчество страхователя":
                assertEquals("Неверно заполнено поле", "Петровна", middlename.getAttribute("value"));
                break;
            case "Дата рождения страхователя":
                assertEquals("Неверно заполнено поле", "13.02.1980", birthDate.getAttribute("value"));
                break;
            case "Пол страхователя":
                assertTrue("Неверно заполнен пол", female.isSelected());
                break;
            case "Серия паспорта":
                assertEquals("Неверно заполнено поле", "1234", passportSeries.getAttribute("value"));
                break;
            case "Номер паспорта":
                assertEquals("Неверно заполнено поле", "567899", passportNumber.getAttribute("value"));
                break;
            case "Дата выдачи паспорта":
                assertEquals("Неверно заполнено поле", "12.02.2001", issueDate.getAttribute("value"));
                break;
            case "Кем выдан":
                assertEquals("Неверно заполнено поле", "ОУФМС ОВД по г. Москва", issuePlace.getAttribute("value"));
                break;
            default:
                throw new AssertionError("Поле '" + checkFieldName + "' не объявлено на странице");
        }


    }
}