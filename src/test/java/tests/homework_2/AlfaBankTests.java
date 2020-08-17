package tests.homework_2;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AlfaBankTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://alfabank.ru";
    }

    @Test
    void archiveDepositsSizeTest() {
        open("/make-money/savings-account/");
        
        $(byTitle("Депозиты")).click();
        $("#product_page_list").$(byText("Архивные депозиты")).click();
       
        $$(".product-cell__cell-back").shouldHave(size(3));
    }

    @Test
    void depositInsuranceWithSiblingTest() {
        open("/make-money/savings-account/");
        
        $x(".//ul[@class='navigation']/li")
                .sibling(4)
                .shouldHave(text("Страхование вкладов"));
    }

    @Test
    void depositInsuranceWithPrecedingTest() {
        open("/make-money/savings-account/");
        
        $(byXpath(".//ul[@class='navigation']/li[7]"))
                .preceding(0)
                .shouldHave(text("Страхование вкладов"));
    }
}
