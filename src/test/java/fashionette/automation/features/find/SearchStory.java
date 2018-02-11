package fashionette.automation.features.find;

import fashionette.automation.features.BaseFeature;
import fashionette.automation.models.Product;
import fashionette.automation.steps.ProductSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchStory extends BaseFeature {

    @Steps
    public ProductSteps product;

    @Test
    public void should_return_list_of_products() {
        product.search_by_name("black bag");
        List<Product> products = product.get_all_searched_items();
        assertThat(products.get(1).name).containsIgnoringCase("black");
        assertThat(products.get(1).lowprice).isLessThan(products.get(1).price);

    }

    @Test
    public void should_return_random_product() {
        product.search_by_name("Fashion Watch Rosegold");
        Product products = product.get_random_searched_item();
    }
} 