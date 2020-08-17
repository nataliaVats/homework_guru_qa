package tests.homework_3;

import homework_3.BaseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static homework_3.WorkingIssue.*;
import static io.qameta.allure.Allure.parameter;


@Owner("Tikhonov Mikhail")
@Feature("Проверка возможности создать Задачу и проверить ее")

public class GitHubTestWithSteps {

    private BaseSteps baseSteps = new BaseSteps();

    @Test
    @DisplayName("Проверка создания задачи через Web и проверка полей созданной задачи через Api")
    public void withStepTest() {
        parameter("Имя репозитория ", getRepositoryName());
        parameter("Имя создаваемой задачи ", getTitle());
        parameter("Текст создаваемой задачи ", getBody());
        parameter("Задача назначается на ", getAuthor());
        parameter("Тэг для задачи ", getLabels());

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
