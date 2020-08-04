package tests.homework_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class PapaJohnsOrder {
    String url = "https://www.papajohns.ru/moscow/";
    String typeOfPizza = "Свинина в кисло-сладком соусе";
    List<SelenideElement> allElements = new ArrayList<>();
    String diametr = "30";

    @Test
    void addToBacketTests() {
        // Открыть сайт
        open(url);
        //Выбрать нужную пиццу диаметр и добавить в корзину
        allElements = $$(byXpath(".//li[@class='OCoeOMqCJdPjzC5s_sRgG']"));
        for (SelenideElement e : allElements) {
            if (e.has(Condition.matchesText(typeOfPizza))) {
                e.$(byXpath(".//div[contains(text(),'" + diametr + "')]")).click();
                e.$(byXpath(".//span[contains(text(),'В корзину')]")).click();
                break;
            }
        }
    }

}
