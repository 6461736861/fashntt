package fashionette.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductDetailsPage extends PageObject {
    private static final Logger _log = LoggerFactory.getLogger(SearchPage.class);

    public void addProduct() {
        String button = "//button[@class='btn__submit']";
        $(button).click();
    }
}
