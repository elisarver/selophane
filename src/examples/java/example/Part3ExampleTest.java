package example;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.selophane.elements.helpers.PageLoader;

/**
 * A test of pages with static public elements.
 */
public class Part3ExampleTest {
    @Test
    public void simple() {
        WebDriver localDriver = new HtmlUnitDriver();
        Part3ExamplePage.initialize(localDriver);

        PageLoader.get(localDriver, "forms.html");

        Assert.assertFalse(Part3ExamplePage.checkBox.isChecked());
        Part3ExamplePage.checkBox.check();
        Assert.assertTrue(Part3ExamplePage.checkBox.isChecked());

        localDriver.close();
    }
}
