package tests.homework_3;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static homework_3.ApiCheckIssueStep.authorizeAndCheckIssue;
import static homework_3.PrivateData.getPassword;
import static homework_3.WorkingIssue.*;

@Owner("Tikhonov Mikhail")
@Feature("Проверка возможности создать Задачу и проверить ее")

public class GithubTestSelenideAndListener {

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    @DisplayName("Проверка создания задачи через Web и проверка полей созданной задачи через Api")
    void plainSelenideAndRestAssuredTest() {
        open(getBaseUrl());

        $(".HeaderMenu-link.no-underline.mr-3").click();
        $("#login_field").setValue(getOwnerRepository());
        $("#password").setValue(getPassword());

        $(by("value", "Sign in")).click();
        $(by("aria-label", "View profile and more")).click();
        $(byText("Your repositories")).click();
        $(byText(getRepositoryName())).click();
        $(by("data-content", "Issues")).click();
        $(".d-none.d-md-block").click();

        $(byText("Assignees")).click();
        switchTo().activeElement();
        $("#assignee-filter-field").setValue(getAuthor());
        $(".js-username").click();
        switchTo().parentFrame();
        $(byText("Assignees")).click();

        $(byText("Labels")).click();
        switchTo().activeElement();
        $("#label-filter-field").setValue(getLabels());
        $(".name").click();
        switchTo().parentFrame();
        $(byText("Labels")).click();

        $(".form-control.input-lg").click();
        $(".form-control.input-lg").setValue(getTitle());
        $("#issue_body").click();
        $("#issue_body").setValue(getBody());

        $(byText("Submit new issue")).click();
        setNUMBER(Integer.parseInt($(".f1-light.text-gray-light")
                .getText()
                .replaceAll("#", "")));

        authorizeAndCheckIssue();
    }
}
