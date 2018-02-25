package fashionette.automation.factories;

import fashionette.automation.models.GuestCustomer;
import fashionette.automation.tech.extentions.BaseFactory;

public class GuestCustomerFactory extends BaseFactory{
    public static GuestCustomer build() {
        GuestCustomer guestCustomer = new GuestCustomer();
        guestCustomer.name = faker.name().firstName() ;
        guestCustomer.surname = "fgdfgdfgdfgdf";
        //.......//
        return guestCustomer;
    }


}
