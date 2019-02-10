package Task_3.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Yakovleva M.V.
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
    public WebElement female;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passportNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//span[text()='Продолжить']")
    public WebElement nextReg;

    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    public WebElement errorMassage;


    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        wait.until(ExpectedConditions.visibilityOf(nextReg));
        //wait.until(ExpectedConditions.visibilityOf(errorMassage));
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

    public String getCheckField(String checkFieldName) {
        switch (checkFieldName) {
            case "Фамилия застрахованного":
                return insuredSurname.getAttribute("value");
            case "Имя застрахованного":
                return insuredName.getAttribute("value");
            case "Дата рождения застрахованного":
                return insuredBirthDate.getAttribute("value");
            case "Фамилия страхователя":
                return surname.getAttribute("value");
            case "Имя страхователя":
                return name.getAttribute("value");
            case "Отчество страхователя":
                return middlename.getAttribute("value");
            case "Дата рождения страхователя":
                return birthDate.getAttribute("value");
            case "Пол страхователя":
                if (female.isSelected()){
                    return "";
                }
                else {return "Неверный пол";}
            case "Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Дата выдачи паспорта":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");
    }


}