package fashionette.automation.steps;

import java.util.List;
import fashionette.automation.models.Product;
import fashionette.automation.pages.HeaderPanel;
import fashionette.automation.pages.MainPage;
import fashionette.automation.pages.SearchPage;

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

    public List<Product> get_all_searched_items() {
       return searchPage.getAllSearchedItems();
    }

    public Product get_random_searched_item() {
        return searchPage.openAnyRandomElement();
    }
}
