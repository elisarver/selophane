package example;

import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.CheckBox;
import org.selophane.elements.helpers.PageLoader;
import org.selophane.elements.impl.internal.ElementFactory;


/**
 * Part2ExampleTest uses original WebDriver PageFactory.
 * This process is smoother than the previous example.
 *
 * @see <a href="http://elisarver.com/blog/2012/12/09/wrapping-webelement-1/">Wrapping WebElement Part 1</a>
 */
public class Part2ExampleTest {
    @FindBy(id = "checkbox")
    CheckBox checkBox;

    protected static Part2ExampleTest initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, Part2ExampleTest.class);
    }

    @Test
    @Ignore
    public void simple() {
        WebDriver localDriver = new HtmlUnitDriver();
        Part2ExampleTest page = initialize(localDriver);

        PageLoader.get(localDriver, "forms.html");

        Assert.assertFalse(page.checkBox.isChecked());
        page.checkBox.check();
        Assert.assertTrue(page.checkBox.isChecked());

        localDriver.close();
    }
}
