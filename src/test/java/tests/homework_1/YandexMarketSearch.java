package tests.homework_1;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexMarketSearch {
    String url = "https://yandex.ru/";
    String market = "Маркет";
    List<SelenideElement> searchResult = new ArrayList<>();

    @Test
    void searchCheapestIphoneTest() {
        //Перейти на страницу маркета
        open(url);
        $(byLinkText(market)).click();
        switchTo().window(1);
        //Вбить в поиске iphone
        $(byXpath((".//input[@id='header-search']"))).setValue("iphone").pressEnter();
        //Перейти на страницу самого дешевого iphone
        searchResult = $$(byXpath(".//article[@class='_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs']"));
        searchResult.get(0).click();
    }
}
