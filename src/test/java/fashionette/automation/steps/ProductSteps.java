package fashionette.automation.steps;

import java.util.List;
import fashionette.automation.models.Product;
import fashionette.automation.pages.HeaderPanel;
import fashionette.automation.pages.MainPage;
import fashionette.automation.pages.ProductDetailsPage;
import fashionette.automation.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class ProductSteps {
    MainPage mainPage;
    HeaderPanel headerPanel;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;

    @Step
    public void search_by_name(String text) {
        headerPanel.fillSearch(text);
        headerPanel.submitSearch();
    }

    @Step
    public void open_search_page() {
        mainPage.open();
        headerPanel.openSearch();
    }

    public List<Product> get_all_searched_items() {
       return searchPage.getAllSearchedItems();
    }

    public Product get_random_searched_item() {
        return searchPage.openAnyRandomElement();
    }

    public void add_product_to_the_cart() {
         productDetailsPage.addProduct();
    }
}
