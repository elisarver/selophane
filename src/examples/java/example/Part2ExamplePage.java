package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.factory.api.ElementFactory;
import org.selophane.elements.widget.CheckBox;

/**
 * A page that needs to be initialized the usual way (new)
 */
public class Part2ExamplePage {
    @FindBy(id = "checkbox")
    public CheckBox checkBox;

    Part2ExamplePage(WebDriver driver) {
        ElementFactory.initElements(driver, this);
    }
}
