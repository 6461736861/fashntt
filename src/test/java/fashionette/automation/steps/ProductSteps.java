package fashionette.automation.steps;

import fashionette.automation.pages.HeaderPanel;
import fashionette.automation.pages.MainPage;
import fashionette.automation.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ProductSteps {
    MainPage mainPage;
    HeaderPanel headerPanel;
    SearchPage searchPage;

    public void search_by_name(String text) {
        mainPage.open();
        headerPanel.openSearch();
        headerPanel.fillSearch(text);
        headerPanel.submitSearch();
    }

    public String get_color() {
        return "";
    }

    public List<Object> get_all_searched_items() {

        //убрать локатор отсюда! добавить модель Сумка
 return null;
    }

    public void openSearchedItem(int index) {

    }
}