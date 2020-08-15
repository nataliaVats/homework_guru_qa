package tests.homework_3.SelenideAndAPI;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Owner("Tikhonov Mikhail")
@Feature("Create and check issue")
public class GitHubTests {
    private final String BASE_URL = "https://github.com/";
    private ApiTest apiTest = new ApiTest();
    private  Issue issue = new Issue();
    private  PrivateData privateData = new PrivateData();

    @Test
    @DisplayName("Web creation, check API")
    void plainSelenideAndRestAssuredTest() {
        open(BASE_URL);

        $(".HeaderMenu-link.no-underline.mr-3").click();
        $("#login_field").setValue(issue.getOwnerRepository());
        $("#password").setValue(privateData.getPassword());

        $(by("value", "Sign in")).click();
        $(by("aria-label", "View profile and more")).click();
        $(byText("Your repositories")).click();
        $(byText(issue.getRepositoryName())).click();
        $(by("data-content", "Issues")).click();
        $(".d-none.d-md-block").click();

        $(byText("Assignees")).click();
        switchTo().activeElement();
        $("#assignee-filter-field").setValue(issue.getAuthor());
        $(".js-username").click();
        switchTo().parentFrame();
        $(byText("Assignees")).click();

        $(byText("Labels")).click();
        switchTo().activeElement();
        $("#label-filter-field").setValue(issue.getLabels());
        $(".name").click();
        switchTo().parentFrame();
        $(byText("Labels")).click();


        $(".form-control.input-lg").click();
        $(".form-control.input-lg").setValue(issue.getTitle());
        $("#issue_body").click();
        $("#issue_body").setValue(issue.getBody());


        $(byText("Submit new issue")).click();
        issue.setNumber(Integer.parseInt($(".f1-light.text-gray-light")
                .getText()
                .replaceAll("#", "")));
        System.out.println(issue.getNumber());
        apiTest.authorizeAndCheckIssue(issue, privateData);
    }

    @Test
    @DisplayName("Web creation, check API")
    public void lambdaStepTest() {
        parameter("Owner name", issue.getOwnerRepository());

        step("Открыть страницу Github", () -> {
            open(BASE_URL);
        });

        step("Пройти авторизацию пользователем " + issue.getOwnerRepository(), () -> {
            $(".HeaderMenu-link.no-underline.mr-3").click();
            $("#login_field").setValue(issue.getOwnerRepository());
            $("#password").setValue(privateData.getPassword());
            $(by("value", "Sign in")).click();
        });

        step("Перейти в раздел мои репозитории", () -> {
            $(by("aria-label", "View profile and more")).click();
            $(byText("Your repositories")).click();

        });

        step("Перейти в репозиторий " + issue.getRepositoryName(),
                () -> $(byText(issue.getRepositoryName())).click());


        step("Перейти в раздел Задачи",
                () -> $(by("data-content", "Issues")).click());

        step("Нажать кнопку New Issue",
                () -> $(".d-none.d-md-block").click());


        step("Выбрать исполнителя " + issue.getAuthor(), () -> {
            $(byText("Assignees")).click();
            switchTo().activeElement();
            $("#assignee-filter-field").setValue(issue.getAuthor());
            $(".js-username").click();
            switchTo().parentFrame();
            $(byText("Assignees")).click();
        });

        step("Выбрать мыркеры " + issue.getLabels(), () -> {
            $(byText("Labels")).click();
            switchTo().activeElement();
            $("#label-filter-field").setValue(issue.getLabels());
            $(".name").click();
            switchTo().parentFrame();
            $(byText("Labels")).click();
        });


        step("Ввести имя задачи " + issue.getTitle(), () -> {
            $(".form-control.input-lg").click();
            $(".form-control.input-lg").setValue(issue.getTitle());
        });

        step("Ввести комментарий к задаче " + issue.getBody(), () -> {
            $("#issue_body").click();
            $("#issue_body").setValue(issue.getBody());
        });

        step("Подтвердить создание задачи ",
                () -> $(byText("Submit new issue")).click());

        step("Сохранить номер задачи для проверки ",
                () -> issue.setNumber(Integer.parseInt($(".f1-light.text-gray-light")
                        .getText()
                        .replaceAll("#", ""))));
        parameter("Number issue", issue.getNumber());
        step("Проверить через API заполненные поля для задачи ",
                () -> apiTest.authorizeAndCheckIssue(issue, privateData));

    }


}
