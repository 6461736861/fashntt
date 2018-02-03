package fashionette.automation.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by rb on 1/21/18.
 */
public class SearchPage extends PageObject {
    List<WebElement> itemsresults = getDriver().findElements(By.cssSelector("[itemprop = \"itemListElement\"]"));

}
