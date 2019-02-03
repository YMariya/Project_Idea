package Selenium.Task_1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 *  Created by Yakovleva Mariya
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


        Actions actions = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);

//2. Нажать на – Страхование
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div[1]/ul/li[6]/span/span")).click();

//3. Выбрать – Путешествия и покупки
        driver.findElement(By.xpath("//*[contains(text(),'Путешествия и покупки')]")).click();

//4. Проверить наличие на странице заголовка – Страхование путешественников

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//H3[text()='Страхование путешественников']"))));
        assertEquals("Страхование путешественников", driver.findElement(By.xpath("//H3[text()='Страхование путешественников']")).getText());


//5. Нажать на – Оформить Онлайн
        driver.findElement(By.xpath("//*[contains(text(),'Оформить онлайн')]")).click();


// 6.На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();

//7. Нажать на – Оформить Онлайн
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();

//8. На вкладке Оформить заполнить поля
        //   Фамилию и Имя, Дату рождения застрахованных
        //   Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        //   Паспортные данные
        //   Контактные данные не заполняем
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Оформление']"))));

        filledData(By.name("insured0_surname"),"IVANOV");
        filledData(By.name("insured0_name"),"IVAN");
        filledData(By.name("insured0_birthDate"),"01012011");

        filledData(By.name("surname"),"Стрыкова");
        filledData(By.name("name"),"Валентина");
        filledData(By.name("middlename"),"Петровна");
        driver.findElement(By.name("birthDate")).click();
        filledData(By.name("birthDate"),"13021980");

        driver.findElement(By.name(("female"))).click();


        filledData(By.name("passport_series"),"1234");
        filledData(By.name("passport_number"),"567899");
        filledData(By.name("issueDate"),"12022001");
        filledData(By.name("issuePlace"),"ОУФМС ОВД по г. Москва");

//9.       Проверить, что все поля заполнены правильно
        assertEquals("Неверно заполнено поле","IVANOV", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","IVAN", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","01.01.2011", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","Стрыкова", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","Валентина", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","Петровна", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertTrue("Неверно заполнен пол",driver.findElement(By.name("female")).isSelected());
        assertEquals("Неверно заполнено поле","13.02.1980", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","1234", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","567899", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","12.02.2001", driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("Неверно заполнено поле","ОУФМС ОВД по г. Москва", driver.findElement(By.name("issuePlace")).getAttribute("value"));


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