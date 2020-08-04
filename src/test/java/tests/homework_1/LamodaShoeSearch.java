package tests.homework_1;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LamodaShoeSearch {
    String url = "https://www.lamoda.ru/";
    String gender = "Мужчинам";
    String typeOfClothes = "Обувь";
    List<SelenideElement> searchResult = new ArrayList<>();

    //Добавить в корзину первый товар в разделе обувь в 40 размере
    @Test
    void searchBookTests() {
        // Открыть lamoda
        open(url);
        // Выбрать пол для кого выбирается товар
        $(byLinkText(gender)).click();
        //Выбрать тип товара
        $(byLinkText(typeOfClothes)).shouldBe(exist);
        $(byLinkText(typeOfClothes)).click();
        $(byLinkText(typeOfClothes)).click();
        //Выбрать i товар в списке
        searchResult = $$(byXpath(".//div[@class='products-list-item dyother dyMonitor']"));
        searchResult.get(0).click();
        //Выбрать размер
        $(byXpath(".//div[@class='_1NAuxdqJ984v_YCs8Mzpml']")).click();
        $(byXpath(".//div[contains(text(),'40 RUS')]")).click();
        //Добавить в корзину
        $(byXpath(".//button[@class='_2EsNAuwPmaSqi_iW4XAFGA undefined']/span")).click();
    }
}
