package fashionette.automation.steps;

import fashionette.automation.models.GuestCustomer;
import fashionette.automation.pages.*;
import net.thucydides.core.annotations.Step;

public class CheckoutSteps {
    CartPage cartPage;

    @Step("start checkout, opening the Cart page")
    public void init_checkout() {
        cartPage.openMiniCart();
    }

    @Step
    public void proceed_as_a_guest_customer() {
       // cartPage.select_guest();
    }

    @Step
    public void enter_address_for_a_guest_customer(GuestCustomer guestCustomer) {
    }

    @Step
    public void select_payment_method() {
    }

    @Step
    public void place_order() {
    }
}
