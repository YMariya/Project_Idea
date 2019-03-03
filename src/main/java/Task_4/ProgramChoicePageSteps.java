package Task_4;

import Task_4.ProgramChoicePage;
import ru.yandex.qatools.allure.annotations.Step;

public class ProgramChoicePageSteps {

    @Step("Выбор суммы страховой защиты")
    public void selectSum (String menuItem){
        new ProgramChoicePage().selectSum(menuItem);
    }

    @Step("Нажатие кнопки - Оформить")
    public void stepIssueButton(){
        new ProgramChoicePage().issueButton.click();
    }
}
