package tests.homework_0;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class YandexSearchingTests {

    @Test
    public void qaGuruRuSearchTest() {
        // Открыть yandex.ru
        open("https://yandex.ru");

        // Ввести в поиск QA Guru
        $(byName("text")).setValue("QA Guru").pressEnter();

        // Проверить наличие qa.guru в результатах поиска
        $(".serp-item").shouldHave(text("qa.guru"));
    }
    
    @Test
    void searchYandex() {
        // Открыть Yandex
        open("https://yandex.com");

        // Ввести Gradle в поиск
        $(byId("text")).setValue("gradle").pressEnter();

        // Проверить, что Gradle появился в результатах поиска
        $("html").shouldHave(text("Gradle"));
    }
}
