package tests.homework_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BNHTests {
    String item = "Sony Alpha a7S III";
    String userName = "Anatoliy";//""Mike";
    String userSurname = "Petrov";// "Mike";
    String userValidEmail = "testtestets@mail.ru";//"mailmail@mail.ru";
    String userValidPassword = "1q2w3e4r5t_";//"123456qaz";
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
    void signInRegisterUserTest() {
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
        signInRegisterUserTest();

        $(by("data-selenium", "userLogin")).click();
        $("#signOut").click();

        $(".twelve login-msg").shouldHave(text("Log In"));
    }

}
