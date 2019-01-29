package Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class InsuranceTest {
    WebDriver driver;
    String BaseUrl;


    @ Before
    public void beforeTest (){
     //   ChromeOptions options = new ChromeOptions();
       // options.addExtensions(new File("C:/Users/User/Downloads/chromedriver_win32"));

        ChromeDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        BaseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BaseUrl);
    }

    @Test
    public void testInsurance(){
       // li.lg-menu__item:nth-child(6) > span:nth-child(1) > span:nth-child(1)
             //   <span class="lg-menu__text">Страхование</span>
       driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[3]/div[1]/div/div/div[1]/ul/li[6]/span/span")).click();
    }

    @After
    public void afterTest(){
driver.quit();
    }




}
