package Selenium.Task_2;

import org.junit.AfterClass;
        import org.junit.Assert;
        import org.junit.BeforeClass;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.util.NoSuchElementException;
        import java.util.Properties;
        import java.util.concurrent.TimeUnit;

/**
 *  Create by Yakovleva Mariya
 */

public class BaseTest {

    protected static WebDriver driver;
    protected static String baseUrl;
    //Добавляется поле Properties, в которое считываеются все переменые из файла properties
    //Считывание реализовано в классе TestProperies

    private static Properties properties = TestProperties.getInstance().getProperties();
    //  public static Properties properties = TestProperties.getInstance().getProperties();


    @BeforeClass
    public static void setUp() throws Exception {
        //Из файла properties считываем какой браузер нам нужено использовать
        //В зависимости от того какой нам нужен браузер, считываем путь и создаем экземпляр
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();

        }


        baseUrl = properties.getProperty("app.url");//записываю св-во app.url из properties файла (ссылка)
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    protected void checkfilledData(String value, By locator) {
        Assert.assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }
}