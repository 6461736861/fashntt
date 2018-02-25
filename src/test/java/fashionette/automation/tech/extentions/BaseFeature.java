package fashionette.automation.tech.extentions;

import com.github.javafaker.Faker;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BaseFeature {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    protected Faker faker = new Faker();

}
