package Task_3_Allure;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import Task_3.Steps.BaseSteps;
import ru.yandex.qatools.allure.junit.AllureRunListener;

/**
 * Created by Yakovleva M.V.
 */
public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure(Failure failure){
        takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Скриншот при ошибке")
    public byte[] takeScreenshot (){
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}