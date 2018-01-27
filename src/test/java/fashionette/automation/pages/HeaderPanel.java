package fashionette.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class HeaderPanel extends PageObject {
    @FindBy(css = ".header__search-icon")
    private WebElementFacade searchIcon;

    @FindBy(css = "[name=q]")
    private WebElementFacade searchField;

    @FindBy(css = ".search-overlay__button")
    private WebElementFacade submitSearchButton;

    public void openSearch() {
        searchIcon.click();
    }

    public void fillSearch(String text) {
        searchField.type(text);
    }

    public void submitSearch() {
        submitSearchButton.click();
    }
}