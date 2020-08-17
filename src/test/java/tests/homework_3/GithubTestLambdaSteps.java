package tests.homework_3;

import homework_3.ApiCheckIssueStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static homework_3.PrivateData.getPassword;
import static homework_3.WorkingIssue.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Owner("Tikhonov Mikhail")
@Feature("Проверка возможности создать Задачу и проверить ее")

public class GithubTestLambdaSteps {

    @Test
    @DisplayName("Проверка создания задачи через Web и проверка полей созданной задачи через Api")
    public void lambdaStepTest() {
        parameter("Имя репозитория ", getRepositoryName());
        parameter("Имя создаваемой задачи ", getTitle());
        parameter("Текст создаваемой задачи ", getBody());
        parameter("Задача назначается на ", getAuthor());
        parameter("Тэг для задачи ", getLabels());

        step("Открыть страницу Github", () -> {
            open(getBaseUrl());
        });

        step("Пройти авторизацию пользователем " + getOwnerRepository(), () -> {
            $(".HeaderMenu-link.no-underline.mr-3").click();
            $("#login_field").setValue(getOwnerRepository());
            $("#password").setValue(getPassword());
            $(by("value", "Sign in")).click();
        });

        step("Перейти в раздел мои репозитории", () -> {
            $(by("aria-label", "View profile and more")).click();
            $(byText("Your repositories")).click();
        });

        step("Перейти в репозиторий " + getRepositoryName(),
                () -> $(byText(getRepositoryName())).click());


        step("Перейти в раздел Задачи",
                () -> $(by("data-content", "Issues")).click());

        step("Нажать кнопку New Issue",
                () -> $(".d-none.d-md-block").click());


        step("Выбрать исполнителя " + getAuthor(), () -> {
            $(byText("Assignees")).click();
            switchTo().activeElement();
            $("#assignee-filter-field").setValue(getAuthor());
            $(".js-username").click();
            switchTo().parentFrame();
            $(byText("Assignees")).click();
        });

        step("Выбрать мыркеры " + getLabels(), () -> {
            $(byText("Labels")).click();
            switchTo().activeElement();
            $("#label-filter-field").setValue(getLabels());
            $(".name").click();
            switchTo().parentFrame();
            $(byText("Labels")).click();
        });

        step("Ввести имя задачи " + getTitle(), () -> {
            $(".form-control.input-lg").click();
            $(".form-control.input-lg").setValue(getTitle());
        });

        step("Ввести комментарий к задаче " + getBody(), () -> {
            $("#issue_body").click();
            $("#issue_body").setValue(getBody());
        });

        step("Подтвердить создание задачи ",
                () -> $(byText("Submit new issue")).click());

        step("Сохранить номер задачи для проверки ",
                () -> setNUMBER(Integer.parseInt($(".f1-light.text-gray-light")
                        .getText()
                        .replaceAll("#", ""))));

        parameter("Number issue", getNUMBER());

        step("Проверить через API заполненные поля для задачи ",
                ApiCheckIssueStep::authorizeAndCheckIssue);

    }

}
