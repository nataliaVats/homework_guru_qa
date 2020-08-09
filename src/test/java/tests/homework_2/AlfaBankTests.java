package tests.homework_2;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AlfaBankTests {

    String depositPage = "https://alfabank.ru/make-money/savings-account/";

    @Test
    void countArchiveDepositsOnPage() {
        open(depositPage);
        $(by("title", "Депозиты")).shouldHave(text("Депозиты")).click();
        $("#product_page_list").shouldHave(text("Архивные депозиты"));
        $(byText("Архивные депозиты")).click();
        $$(".product-cell__cell-back").shouldHave(size(3));
    }

    @Test
    void callDepositInsuranceV1() {
        open(depositPage);
        $(byXpath(".//ul[@class='navigation']/li"))
                .sibling(4)
                .shouldHave(text("Страхование вкладов"))
                .click();
    }

    @Test
    void callDepositInsuranceV2() {
        open(depositPage);
        $(byXpath(".//ul[@class='navigation']/li[7]"))
                .preceding(0)
                .shouldHave(text("Страхование вкладов"))
                .click();
    }


}
