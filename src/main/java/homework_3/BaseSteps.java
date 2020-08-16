package homework_3;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static homework_3.ApiCheckIssueStep.authorizeAndCheckIssue;
import static homework_3.PrivateData.getPassword;
import static homework_3.WorkingIssue.setNUMBER;

public class BaseSteps {
    private final String BASE_URL = "https://github.com/";
    private final String OWNER_REPOSITORY = "MikeTikhonov";
    private final String AUTHOR = "MikeTikhonov";
    private final String TITTLE = "First Issue";
    private final String BODY = "QA guru";
    private final String REPOSITORY_NAME = "MyTestRepository";
    private final String LABELS = "bug";


    @Step("Открыть страницу Github")
    public void openMainPage() {
        Selenide.open(BASE_URL);
    }

    @Step("Пройти авторизацию пользователем" + OWNER_REPOSITORY)
    public void authorizationByLoginAndPassword() {
        Selenide.$(".HeaderMenu-link.no-underline.mr-3").click();
        Selenide.$("#login_field").setValue(OWNER_REPOSITORY);
        Selenide.$("#password").setValue(getPassword());
        Selenide.$(Selectors.by("value", "Sign in")).click();
    }


    @Step("Перейти в раздел мои репозитории")
    public void goToMyRepositories() {
        Selenide.$(Selectors.by("aria-label", "View profile and more")).click();
        Selenide.$(Selectors.byText("Your repositories")).click();
    }

    @Step("Перейти в репозиторий " + REPOSITORY_NAME)
    public void goToCurrentRepository() {
        Selenide.$(Selectors.byText(REPOSITORY_NAME)).click();
    }


    @Step("Перейти в раздел Задачи")
    public void goToTasks() {
        Selenide.$(Selectors.by("data-content", "Issues")).click();
    }


    @Step("Нажать кнопку New Issue")
    public void createNewIssue() {
        Selenide.$(".d-none.d-md-block").click();
    }


    @Step("Выбрать исполнителя " + AUTHOR)
    public void chooseAssegnee() {
        Selenide.$(Selectors.byText("Assignees")).click();
        Selenide.switchTo().activeElement();
        Selenide.$("#assignee-filter-field").setValue(AUTHOR);
        Selenide.$(".js-username").click();
        Selenide.switchTo().parentFrame();
        Selenide.$(Selectors.byText("Assignees")).click();
    }


    @Step("Выбрать маркеры " + LABELS)
    public void setMarkers() {
        Selenide.$(Selectors.byText("Labels")).click();
        Selenide.switchTo().activeElement();
        Selenide.$("#label-filter-field").setValue(LABELS);
        Selenide.$(".name").click();
        Selenide.switchTo().parentFrame();
        Selenide.$(Selectors.byText("Labels")).click();
    }

    @Step("Ввести имя задачи " + TITTLE)
    public void setIssueName() {
        Selenide.$(".form-control.input-lg").click();
        Selenide.$(".form-control.input-lg").setValue(TITTLE);
    }

    @Step("Ввести комментарий к задаче " + BODY)
    public void addBodyToIssue() {
        Selenide.$("#issue_body").click();
        Selenide.$("#issue_body").setValue(BODY);
    }

    @Step("Подтвердить создание задачи")
    public void acceptCreateIssue() {
        Selenide.$(Selectors.byText("Submit new issue")).click();
    }

    @Step("Сохранить номер задачи для проверки")
    public void saveIssueNumber() {
        setNUMBER(Integer.parseInt(Selenide.$(".f1-light.text-gray-light")
                .getText()
                .replaceAll("#", "")));
    }

    @Step("Проверить созданную задачу")
    public void checkIssueByAPI() {
        authorizeAndCheckIssue();
    }

}
