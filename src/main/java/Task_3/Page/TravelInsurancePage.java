package Task_3.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

/**
 * Yakovleva M.V.
 */
public class TravelInsurancePage {
    @FindBy(xpath = "//*[contains(text(),'Оформить онлайн')]")
    public WebElement sendButton;

    @FindBy(xpath = "//H3[text()='Страхование путешественников']")
    public WebElement title;

    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        wait.until(ExpectedConditions.visibilityOf(title));
    }

}
