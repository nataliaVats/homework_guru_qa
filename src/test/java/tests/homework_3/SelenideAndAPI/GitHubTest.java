package tests.homework_3.SelenideAndAPI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class GitHubTest {
    ApiTest apiTest = new ApiTest();
    private final Issue issue = new Issue();

    @Test
    @DisplayName("Test repository exists")
    void createIssueTest(){
        open("https://github.com/");

        $(".HeaderMenu-link.no-underline.mr-3").click();
        $("#login_field").setValue("MikeTikhonov");
        $("#password").setValue("Xyvje9-wyjham-coqqef");
        $(by("value","Sign in")).click();
        $(by("aria-label","View profile and more")).click();
        $(byText("Your repositories")).click();
        $(byText(issue.getRepesitoryName())).click();
        $(by("data-content","Issues")).click();
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
        issue.setNumber(Long.parseLong($(".f1-light.text-gray-light")
                .getText()
                .replaceAll("#","")));
        System.out.println(issue.getNumber());
        apiTest.authorizeAndCheckIssue(issue);
    }

    
}
