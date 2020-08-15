package tests.homework_3.SelenideAndAPI;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ApiTest {

    public void authorizeAndCheckIssue(Issue issue, PrivateData privateData) {
        given()
                .header("Authorization", "token " + privateData.getToken())
                .baseUri("https://api.github.com")
                .when()
                .get("/repos/" + issue.getAuthor() + "/" + issue.getRepositoryName() +
                        "/issues/" + issue.getNumber())
                .then()
                .assertThat()
                .statusCode(200)
                .body("body", equalTo(issue.getBody()))
                .body("title", equalTo(issue.getTitle()))
                .body("number", equalTo(issue.getNumber()))
                .body("assignee.login", equalTo(issue.getAuthor()))
                .body("labels.name.flatten()", hasItems(issue.getLabels()));
    }
}
