package Task_3.Steps;

import Task_2.ChoosePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

import static Task_3.Steps.BaseSteps.driver;

/**
 * Yakovleva M.V.
 */
public class ChoosePolicySteps {

    @Step("Выбрана минимальная сумма")
    public void stepChooseMinSum() {
        new ChoosePolicyPage(driver).minSum.click();
    }

    @Step("Нажата кнопка - Оформить")
    public void stepClickFormalizeButton() {
        new ChoosePolicyPage(driver).formalizeButton.click();
    }
}