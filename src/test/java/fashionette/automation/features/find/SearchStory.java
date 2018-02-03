package fashionette.automation.features.find;

import fashionette.automation.features.BaseFeature;
import fashionette.automation.steps.ProductSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class SearchStory extends BaseFeature {

    @Steps
    public ProductSteps product;

    @Test
    public void should_return_list_of_products() {
        product.search_by_name("schwarze clutch");

     //  get_all_searched_items();
       // product.openSearchedItem(faker.number().numberBetween(1,items.size()));
       product.get_all_searched_items_steps();

      //  String color = product.get_color();
        //assertThat(color).isEqualTo("schwarz");
    }
} 