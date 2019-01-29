package Selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**

 */
public class InsuranceTest {
    WebDriver driver;
    String baseURL;

    @Before
    public void befoTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();//инициализируем переменную driver

        //1. Перейти на страницу http://www.sberbank.ru/ru/person
        baseURL="http://www.sberbank.ru/ru/person";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();//разворачивает окно на весь экран
        driver.get(baseURL);
    }

    @Test
    public void autoTestInsurance() {

        //2. Нажать на – Застраховать себя и имущество
        //3. Выбрать – Страхование путешественников
        Actions actions = new Actions(driver);
        //Выполняем наведение курсора мыши на элемент, в выпадающем меню нажимаем на элемент
        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div[1]/ul/li[6]/span/span")).click();
       // driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div/div[2]/div/div/div/div[4]/div[1]/div/div/div[1]/ul/li[6]/div/div/div/div[1]/ul/li[1]"));
        driver.findElement(By.tagName("Путешествия и покупки"));

        //wait.until(ExpectedConditions.visibilityOf(mainElement));
        //actions.moveToElement(mainElement).perform();
       // wait.until((ExpectedConditions.visibilityOf(subElement)));
       // actions.moveToElement(subElement).click().perform();

        //4. Проверить наличие на странице заголовка – Страхование путешественников
        WebElement elementTitle = driver.findElement(By.xpath("//h1[text()='Страхование путешественников']"));
        assertEquals("Отсутствует заголовок Страхование путешественников","Страхование путешественников",elementTitle.getText());
        //5. Нажать на – Оформить Онлайн

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")))).click();


        //6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        //переключение между вкладками
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        //Вариант для общего развития
        /*
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }*/


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='b-form-box-title ng-binding'][text()='Минимальная']")))).click();


        //7. Нажать Оформить
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Оформить')]")))).click();

        //8. На вкладке Оформить заполнить поля
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Оформление']"))));

        filledData(By.name("insured0_surname"),"IVANOV");
        filledData(By.name("insured0_name"),"LEV");
        filledData(By.name("insured0_birthDate"),"01012011");

        filledData(By.name("surname"),"Иванова");
        filledData(By.name("name"),"Елена");
        filledData(By.name("middlename"),"Петровна");
        driver.findElement(By.name("birthDate")).click();
        filledData(By.name("birthDate"),"02021984");

        driver.findElement(By.name(("female"))).click();


        filledData(By.name("passport_series"),"1234");
        filledData(By.name("passport_number"),"567890");
        filledData(By.name("issueDate"),"12022010");
        filledData(By.name("issuePlace"),"Отделением ОВД по г. Москва");

        //9.       Проверить, что все поля заполнены правильно
        assertEquals("Неверно заполнено поле","IVANOV", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","LEV", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","01.01.2011", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","Иванова", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","Елена", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","Петровна", driver.findElement(By.name("middlename")).getAttribute("value"));
        //Assert.assertEquals("Неверно заполнено поле пол", "0",driver.findElement(By.name("female")).getAttribute("value"));
        assertTrue("Неверно заполнен пол",driver.findElement(By.name("female")).isSelected());
        assertEquals("Неверно заполнено поле","02.02.1984", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","1234", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","567890", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","12.02.2010", driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","Отделением ОВД по г. Москва", driver.findElement(By.name("issuePlace")).getAttribute("value"));


        //10.   Нажать продолжить
        driver.findElement(By.xpath("//span[text()='Продолжить']")).click();

        //11.   Проверить, что появилось сообщение - Заполнены не все обязательные поля
        WebElement errorMassage = driver.findElement(By.xpath("//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']"));
        assertEquals("Отсутствует сообщение об ошибке","Заполнены не все обязательные поля",errorMassage.getText());


    }

    //Метод для заполнения полей
    public void filledData(By locator, String value){
        driver.findElement(locator).clear();//очищаем поле перед заполнением
        driver.findElement(locator).sendKeys(value);//заполнение
    }

    @After
   public void afterTest() {
    driver.quit();//закрываем браузер
    }
}