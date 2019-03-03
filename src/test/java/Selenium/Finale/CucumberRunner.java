package Selenium.Finale;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resource/"}, glue = {"Finale.Steps"},
        plugin = {"Finale.Util.AllureReporter"}
)
public class CucumberRunner {
}