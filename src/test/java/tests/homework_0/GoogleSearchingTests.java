package tests.homework_0;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GoogleSearchingTests {

    @Test
    public void ruSelenideOrgSearchTest() {
        // Open google.com
        open("https://google.com");

        // Type "Selenide" in the Search field
        $(byName("q")).setValue("Selenide").pressEnter();

        // Make sure "ru.selenide.org" appears in search result
        $(".g").shouldHave(text("ru.selenide.org"));
    }

    @Test
    public void qaGuruSearchTest() {
        // Открыть google.com
        open("https://google.com");

        // Ввести в поиск QA Guru
        $(byName("q")).setValue("QA Guru").pressEnter();

        // Проверить наличие qa.guru в результатах поиска
        $(".g").shouldHave(text("qa.guru"));
    }

    @Test
    public void yandexRuSearchTest() {
        // Открыть google.com
        open("https://google.com");

        // Ввести в поиск Yandex
        $(byName("q")).setValue("Yandex").pressEnter();

        // Проверить наличие yandex.ru в результатах поиска
        $(".g").shouldHave(text("yandex.ru"));
    }
    
    @Test
    pablic void searchYandex() {
        // Открыть Yandex
        open("https://yandex.com");

        // Ввести Gradle в поиск
        $(byId("text")).setValue("gradle").pressEnter();

        // Проверить, что Gradle появился в результатах поиска
        $("html").shouldHave(text("Gradle"));
    }

}
