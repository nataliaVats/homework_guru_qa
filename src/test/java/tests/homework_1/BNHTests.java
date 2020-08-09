package tests.homework_1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BNHTests {
    String item = "Sony Alpha a7S III";
    String userName = "Mike";
    String userSurname = "Mike";
    String userValidEmail = "gladmonk@mail.ru";
    String userValidPassword = "1qaz2wsx3edc";
    String userInValidEmail = "bozoc@royatillmail.top";
    String userInValidPassword = "qa$zwsx_122121";



    @Test
    void searchPhotoCameraUnregisterUserTest() {
        open("https://www.bhphotovideo.com/");

        $(by("data-selenium", "topSearch")).setValue(item).pressEnter();
        $(by("data-selenium", "miniProductPageProductName")).shouldHave(text(item)).click();

        $(by("data-selenium", "productTitle")).shouldHave(text(item));
    }

    @Test
    void registrationUserTest() {
        open("https://www.bhphotovideo.com/");

        $(by("data-selenium", "userLogin")).click();
        $(".create-account").click();
        $(by("data-selenium", "first")).setValue(userName);
        $(by("data-selenium", "last")).setValue(userSurname);
        $("#create-email").sendKeys(userValidEmail);
        $("#create-password").setValue(userValidPassword);
        $(by("value", "Create Account")).click();

        $("#js-loginname").shouldHave(text(userName));
    }

    @Test
    void registerUserLoginTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        open("https://www.bhphotovideo.com/");

        $(by("data-selenium", "userLogin")).click();
        $("button.login").click();
        $(by("data-selenium", "emailAddress")).setValue(userValidEmail);
        $(by("data-selenium", "password")).setValue(userValidPassword);
        $(by("data-selenium", "submitBtn")).click();

        $("#js-loginname").shouldHave(text(userName));
    }

    @Test
    void unregisterUserLoginTest() {
        open("https://www.bhphotovideo.com/");

        $(by("data-selenium", "userLogin")).click();
        $("button.login").click();
        $(by("data-selenium", "emailAddress")).setValue(userInValidEmail);
        $(by("data-selenium", "password")).setValue(userInValidPassword);
        $(by("data-selenium", "submitBtn")).click();

        $(".m-error").shouldHave(text("Incorrect email address or password"));
    }

    @Test
    void signOutTest() {
        registerUserLoginTest();

        $(by("data-selenium", "userLogin")).click();
        $("#signOut").click();

        $(".twelve login-msg").shouldHave(text("Log In"));
    }

}
