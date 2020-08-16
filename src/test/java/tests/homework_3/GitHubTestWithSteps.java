package tests.homework_3;

import homework_3.BaseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("Tikhonov Mikhail")
@Feature("Проверка возможности создать Задачу и проверить ее")

public class GitHubTestWithSteps {

    private BaseSteps baseSteps = new BaseSteps();

    @Test
    @DisplayName("Проверка создания задачи через Web и проверка полей созданной задачи через Api")
    public void withStepTest() {
        baseSteps.openMainPage();

        baseSteps.authorizationByLoginAndPassword();
        baseSteps.goToMyRepositories();
        baseSteps.goToCurrentRepository();
        baseSteps.goToTasks();
        baseSteps.createNewIssue();
        baseSteps.chooseAssegnee();
        baseSteps.setMarkers();
        baseSteps.setIssueName();
        baseSteps.addBodyToIssue();
        baseSteps.acceptCreateIssue();
        baseSteps.saveIssueNumber();

        baseSteps.checkIssueByAPI();
    }


}
