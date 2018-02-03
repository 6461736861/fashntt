package fashionette.automation.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SearchPage extends PageObject {

    public int get_all_searched_items() {

        System.out.println("itemsresults = " + getDriver().findElements(By.cssSelector("[itemprop = \"itemListElement\"]")).size());
        return getDriver().findElements(By.cssSelector("[itemprop = \"itemListElement\"]")).size();

    }
}
