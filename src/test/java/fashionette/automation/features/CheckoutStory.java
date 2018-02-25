package fashionette.automation.features;

import com.sun.tools.classfile.Attribute;
import fashionette.automation.factories.GuestCustomerFactory;
import fashionette.automation.models.GuestCustomer;
import fashionette.automation.models.Product;
import fashionette.automation.steps.CheckoutSteps;
import fashionette.automation.steps.ProductSteps;
import fashionette.automation.tech.extentions.BaseFeature;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class CheckoutStory extends BaseFeature {

    @Steps
    public ProductSteps product;
    @Steps
    public CheckoutSteps checkout;

    @Test
    public void add_product_to_the_cart() {
        GuestCustomer guestCustomer = GuestCustomerFactory.build();
        product.search_by_name("Fashion Watch Rosegold");
        Product products = product.get_random_searched_item();
        product.add_product_to_the_cart();
        checkout.init_checkout();
        checkout.proceed_as_a_guest_customer();
        checkout.enter_address_for_a_guest_customer(guestCustomer);
        checkout.select_payment_method();
        checkout.place_order();
    }


}
