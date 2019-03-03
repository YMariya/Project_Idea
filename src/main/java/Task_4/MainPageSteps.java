package Task_4;

import Task_4.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {
    @Step("Выбран пункт меню {0}")
    public void selectMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран вид страхования {0}")
    public void selectSubMenu(String menuItem) {
        new MainPage().selectSubMenu(menuItem);
    }
}
