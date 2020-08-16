package homework_3;

import org.hamcrest.Matchers;

import static homework_3.PrivateData.getToken;
import static homework_3.WorkingIssue.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiCheckIssueStep {

    public static void authorizeAndCheckIssue() {
        given()
                .header("Authorization", "token " + getToken())
                .baseUri("https://api.github.com")
                .when()
                .get("/repos/" + getAuthor() + "/" + getRepositoryName() +
                        "/issues/" + getNUMBER())
                .then()
                .assertThat()
                .statusCode(200)
                .body("body", equalTo(getBody()))
                .body("title", equalTo(getTitle()))
                .body("number", equalTo(getNUMBER()))
                .body("assignee.login", equalTo(getAuthor()))
                .body("labels.name.flatten()", Matchers.hasItems(getLabels()));
    }
}
