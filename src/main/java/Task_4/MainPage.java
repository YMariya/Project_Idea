package Task_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Task_4.BaseSteps;

public class MainPage {

    @FindBy(xpath = "//*[contains(text(),'Страхование')]")
    WebElement mainMenu;

    @FindBy(xpath = "//*[contains(text(),'Путешествия и покупки')]")
    WebElement subMenu;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div[1]/ul/li[6]/span/span")).click();
    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath(".//a[contains(text(),'" + menuItem + "')]")).click();
    }
}
