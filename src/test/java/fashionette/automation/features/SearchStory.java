package fashionette.automation.features;

import fashionette.automation.tech.extentions.BaseFeature;
import fashionette.automation.models.Product;
import fashionette.automation.steps.ProductSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchStory extends BaseFeature {

    @Steps
    public ProductSteps product;

    @Before
    public void open_search_page_before() {
        product.open_search_page();
    }

    @Test
    public void should_return_list_of_products() {
        product.search_by_name("black bag");
        List<Product> products = product.get_all_searched_items();
        Product firstProduct = products.get(1);
        assertThat(firstProduct.name).containsIgnoringCase("black");
        assertThat(firstProduct.lowprice).isLessThan(firstProduct.price);
    }

    @Test
    public void should_return_random_product() {
        product.search_by_name("Fashion Watch Rosegold");
        Product products = product.get_random_searched_item();
    }
} 