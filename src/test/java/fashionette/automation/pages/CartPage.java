package fashionette.automation.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.remote.server.handler.FindElement;

public class CartPage extends PageObject {

    public void openMiniCart() {
         String miniCartButton="//a[@class='cart--header__button hidden-xs']";
        $(miniCartButton).click();
    }
}
