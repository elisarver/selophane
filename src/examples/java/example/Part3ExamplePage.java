package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.factory.api.ElementFactory;
import org.selophane.elements.widget.CheckBox;

/**
 * A page that can be initialized statically.
 */
public class Part3ExamplePage {
    @FindBy(id = "checkbox")
    public static CheckBox checkBox;

    public static Part3ExamplePage initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, Part3ExamplePage.class);
    }
}
