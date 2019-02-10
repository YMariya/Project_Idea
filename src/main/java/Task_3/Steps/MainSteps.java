package Task_3.Steps;

import Task_2.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Yakovleva M.V.
 */
public class MainSteps extends BaseSteps {

    @Step("Выбран пункт меню - Застраховать себя и имущество")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("Выбран пункт меню - Страхование путешественников")
    public void setSelectSubMenu() {
        new MainPage(driver).selectSubMenu(driver);
    }


}