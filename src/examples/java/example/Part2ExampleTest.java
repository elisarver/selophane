package example;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.selophane.elements.helpers.PageLoader;


/**
 * Part2ExampleTest uses original WebDriver PageFactory.
 * This process is smoother than the previous example.
 *
 * @see <a href="http://elisarver.com/2012/12/09/wrapping-webelement-1">Wrapping WebElement Part 1</a>
 */
public class Part2ExampleTest {
    @Test
    public void simple() {
        WebDriver localDriver = new HtmlUnitDriver();
        Part2ExamplePage page = new Part2ExamplePage(localDriver);

        PageLoader.get(localDriver, "forms.html");

        Assert.assertFalse(page.checkBox.isChecked());
        page.checkBox.check();
        Assert.assertTrue(page.checkBox.isChecked());

        localDriver.close();
    }
}
