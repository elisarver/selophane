package example;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selophane.elements.base.UniqueElementLocator;
import org.selophane.elements.helpers.PageLoader;
import org.selophane.elements.widget.CheckBox;
import org.selophane.elements.widget.CheckBoxImpl;

/**
 * Part2ExampleTest uses original WebDriver PageFactory.
 * This is to show the awkwardness of manually wrapping WebElements.
 *
 * @see <a href="http://elisarver.com/2012/12/09/wrapping-webelement-1">Wrapping WebElement Part 1</a>
 */
public class Part1ExampleTest {
    @FindBy(id = "checkbox")
    WebElement checkBox;

    @Test
    public void simple() {
        final WebDriver driver = new HtmlUnitDriver();
        PageFactory.initElements(driver, this);

        PageLoader.get(driver, "forms.html");
        CheckBox wrappedCheckBox = new CheckBoxImpl(new UniqueElementLocator() {
            
            @Override
            public WebElement findElement() {
                
                return checkBox;
            }

            @Override
            public WebDriver getWebDriver() {
                return driver;
            }
        });

        Assert.assertFalse(wrappedCheckBox.isChecked());
        wrappedCheckBox.check();
        Assert.assertTrue(wrappedCheckBox.isChecked());

        driver.close();
    }
}
