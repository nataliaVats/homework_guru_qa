package tests.homework_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


public class OzonSearch {
    @Test
    void searchBookTests() {
        String bookForSearch = "Harry Potter and the Philosopher's Stone";

        open("https://www.ozon.ru/");

        $(byName("search")).setValue(bookForSearch).pressEnter();

        $(byTitle("Товары не в наличии").shouldNot(exist);
        $(".widget-search-result-container", 1).$(byText(bookForSearch)).click();
          
        //проверить что редиректит на литрес
        assertTrue(url().matches("[litres]")); 
    }
}
