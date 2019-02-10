package Task_3.Page;

import org.openqa.selenium.By;
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
public class MainPage {

    @FindBy(xpath = "//ul[contains(@class,'alt-menu-mid')]/li[5]/a")
    WebElement mainMenuItem;

    @FindBy(xpath = "//li[5]//div[contains(@class,'list__item_level_1')]")
    WebElement subMenuItem;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenuItem.findElement(By.xpath(".//span[@class='multiline']/*[contains(text(),'" + menuItem + "')]")).click();
    }

    public void selectSubMenu(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(subMenuItem)).click();
    }


}