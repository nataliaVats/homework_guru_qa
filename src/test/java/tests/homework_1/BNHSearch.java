package tests.homework_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BNHSearch {
    String url = "https://www.bhphotovideo.com/";
    String item = "Sony Alpha a7S III";

    @Test
    void searchBookTests() {
        open(url);
        
        // Ввести в строку поиска название товара
        /* <input type="text" id="top-search-input" data-selenium="topSearch" 
            class="twelve js-placeholder js-topsearch" name="Ntt" autocomplete="off" placeholder="Search " value=""> */
        // $(byXpath(".//input[@id='top-search-input']")).setValue(item).pressEnter();
        // $("#top-search-input").setValue(item).pressEnter();
        $(by("data-selenium", "topSearch")).setValue(item).pressEnter();
        
        // Проверить есть ли в результатах поиска товар и перейти в первый товар
//         $$(byXpath(".//div[@data-selenium='miniProductPage']"))
//                 .get(0)
//                 .$(byXpath(".//span[@data-selenium='miniProductPageProductName']"))
//                 .click();
        $(by("data-selenium", "miniProductPageProductName")).shouldHave(text(item)).click();
        
        // Проверить сожержит ли выбранный товар название товара название из поиска
        $(by("data-selenium", "productTitle")).shouldHave(text(item))
    }
}
