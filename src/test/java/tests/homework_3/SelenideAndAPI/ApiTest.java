package tests.homework_3.SelenideAndAPI;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    public void authorizeAndCheckIssue(Issue issue) {
        System.out.println(issue.getNumber());
        given()
                .header("Authorization", "token 9f6f42146ced3a9fc5c29ce5b5f0f92923a502b8")
                .baseUri("https://api.github.com")
                .when()
                .get("/repos/" + issue.getAuthor() + "/" + issue.getRepesitoryName() +
                        "/issues/" + issue.getNumber())
                .then()
                .assertThat()
                .statusCode(200)
                .body("body", equalTo(issue.getBody()))
                .body("title", equalTo(issue.getTitle()))
                .body("number", equalTo(issue.getNumber()));
    }
}
