package Finale.Steps;

import Finale.Page.YandexBasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexBasePageSteps {

    @Step("Выбран пункт меню - {0}")
    public void stepSelectMenuItem (String menuItem) {
        new YandexBasePage(BaseSteps.getDriver()).selectMenuItem(menuItem);
    }
}