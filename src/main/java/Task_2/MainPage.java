package Task_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  Create by Yakovleva Mariya
 */

public class MainPage {

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div[1]/ul/li[6]/span/span")
    WebElement mainMenuItem;

    @FindBy(xpath = "//*[contains(text(),'Путешествия и покупки')]")
    public WebElement subMenuItem;

    //Выполняем инициализацию элементов
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenuItem.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div[1]/ul/li[6]/span/span")).click();
    }

   public void selectSubMenu(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
       wait.until(ExpectedConditions.visibilityOf(subMenuItem)).click();
   }


}