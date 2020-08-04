package tests.homework_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class OzonSearch {
    String url = "https://www.ozon.ru/";
    String bookForSearch = "Harry Potter and the Philosopher's Stone";
    String searchBar = "search";

    @Test
    void searchBookTests() {
        // Открыть ozon
        open(url);
        // Ввести  в поиск Книга о гарри
        $(byName(searchBar)).setValue(bookForSearch).pressEnter();

        // Проверить, что книга есть в результате поиска
        $(byPartialLinkText(bookForSearch)).shouldHave(text(bookForSearch));
        // Найти книгу если она есть перейти в нее
        $(byPartialLinkText(bookForSearch)).exists();
        $(byPartialLinkText(bookForSearch)).click();
        //проверить что редиректит на литрес
        url().matches("[litres]");

    }


}
