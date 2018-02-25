package fashionette.automation.pages;

import fashionette.automation.models.Product;
import fashionette.automation.tech.extentions.ListExtension;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageObject {

    private static final Logger _log = LoggerFactory.getLogger(SearchPage.class);

    public List<Product> getAllSearchedItems() {
        List<WebElementFacade> all = findAll(By.cssSelector("[itemprop=itemListElement]"));
        List<Product> products = new ArrayList<>();
        for (WebElementFacade item : all) {
            Product product = new Product();
            product.name = item.findElement(By.cssSelector(".product--list__item__name")).getText();
            product.brand = item.findElement(By.cssSelector("[data-product-brand]")).getText();
            product.price = Double.valueOf(item.findElement(By.cssSelector("[data-product-price]")).getAttribute("content"));
            if (item.findElements(By.cssSelector("[data-product-price-special]")).size() != 0) {
                product.lowprice = Double.valueOf(item.findElement(By.cssSelector("[data-product-price-special]")).getAttribute("content"));
                products.add(product);
            }
            _log.info(product.toString());
        }
        return products;
    }

    public Product openAnyRandomElement() {
        List<WebElementFacade> all = findAll(By.cssSelector("[itemprop=itemListElement]"));
        // WebElementFacade randomElement = all.get(new Random().nextInt(all.size()));
        WebElementFacade randomElement = ListExtension.randomItem(all);
        clickOn(randomElement);

        return null;
    }
}
