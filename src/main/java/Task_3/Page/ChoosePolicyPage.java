package Task_3.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Task_3.Steps.BaseSteps;

/**
 * Created by Yakovleva M.V.
 */
public class ChoosePolicyPage {

    @FindBy(xpath = "//div[@class='b-form-box-title ng-binding'][text()='Минимальная']")
    public WebElement minSum;

    @FindBy(xpath = "//span[contains(text(),'Оформить')]")
    public WebElement formalizeButton;


    public ChoosePolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(minSum));
        wait.until(ExpectedConditions.visibilityOf(formalizeButton));
    }

}
