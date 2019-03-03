package Selenium.Task_4;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"src/java/task_4"},
        plugin = {
                "util.AllureReporter",
        }
)
public class CucumberRunner {

}