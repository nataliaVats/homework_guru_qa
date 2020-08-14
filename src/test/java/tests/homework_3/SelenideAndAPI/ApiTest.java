package tests.homework_3.SelenideAndAPI;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    public void authorizeAndCheckIssue(Issue issue) {

        System.out.println(issue.getNumber());
        given()
                .header("Authorization", "token e3043b9cc2b1649cd2e8f2ce87c384c362d53eb9")
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
                .body("labels.name", equalTo(issue.getLabels()));
    }
}
