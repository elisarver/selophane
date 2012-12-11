package example;

import junit.framework.Assert;
import me.selophane.elements.CheckBox;
import me.selophane.elements.helpers.PageLoader;
import me.selophane.elements.impl.internal.ElementFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;


/**
 * Part2ExampleTest uses original WebDriver PageFactory.
 * This process is smoother than the previous example.
 *
 * @see <a href="http://elisarver.com/blog/2012/12/09/wrapping-webelement-1/">Wrapping WebElement Part 1</a>
 */
public class Part2ExampleTest {
    private final WebDriver driver;

    @FindBy(id = "checkbox")
    CheckBox checkBox;

    /**
     * This fulfills a sorta contract between this test object and itself.
     * It's used by the static factory to generate an instance of the test,
     * which is silly on its face, but it's perfectly valid (and sorta neat)
     *
     * @param driver A web driver.
     */
    protected Part2ExampleTest(WebDriver driver) {
        this.driver = driver;
    }

    protected static Part2ExampleTest initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, Part2ExampleTest.class);
    }

    @Test
    public void simple() {
        WebDriver driver = new FirefoxDriver();
        Part2ExampleTest page = initialize(driver);

        PageLoader.get(driver, "forms.html");

        Assert.assertFalse(page.checkBox.isChecked());
        page.checkBox.check();
        Assert.assertTrue(page.checkBox.isChecked());

        driver.close();
    }
}
