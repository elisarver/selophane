package org.selophane.elements;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.selophane.elements.helpers.FormTestObject;

/**
 * Test the form element types.
 */
@RunWith(JUnit4.class)
public class FormTest {
    static WebDriver driver;
    static FormTestObject testObject;

    @BeforeClass
    public static void beforeClass() {
        driver = new HtmlUnitDriver();
        testObject = FormTestObject.initialize(driver);
    }

    @Test
    public void isChecked() {
        testObject.get();
        Assert.assertFalse(testObject.checkbox.isChecked());
    }

    @Test
    public void check() {
        testObject.get();
        testObject.checkbox.check();
        Assert.assertTrue(testObject.checkbox.isChecked());
    }

    @Test
    public void uncheck() {
        testObject.get();
        testObject.checkbox.click();
        testObject.checkbox.uncheck();
        Assert.assertFalse(testObject.checkbox.isChecked());
    }

    @Test
    public void selectWiredProperly() {
        testObject.get();
        testObject.option1.selectByIndex(0);
        Assert.assertEquals(1, testObject.option1.getAllSelectedOptions().size());
    }

    @Test
    public void getLabelsList() {
        testObject.get();
        for (Label label : testObject.labels) {
            Assert.assertNotNull(label.getFor());
        }
    }

    @Test
    public void getElementLabelsList() {
        testObject.get();
        for (Element webElementLabel : testObject.elementLabels) {
            Assert.assertNotNull(webElementLabel.getAttribute("for"));
        }
    }

    @Test
    public void getWebElementLabelsList() {
        testObject.get();
        for (WebElement webElementLabel : testObject.webElementLabels) {
            Assert.assertNotNull(webElementLabel.getAttribute("for"));
        }
    }

    @Test
    public void getWebElement() {
        testObject.get();
        Assert.assertTrue(testObject.labelForTextB.isDisplayed());
    }

    @Test
    public void formElement() {
        testObject.get();
        Assert.assertTrue(testObject.element.elementWired());
    }

    @Test
    public void textInputSet() {
        testObject.get();
        testObject.texta.set("TestText");
        Assert.assertEquals("TestText", testObject.texta.getAttribute("value"));
    }

    @Test
    public void textInputClear() {
        testObject.get();
        testObject.texta.set("TestText");
        testObject.texta.clear();
        Assert.assertEquals("", testObject.texta.getAttribute("value"));
    }

    @Test
    public void textInputGetValue() {
        testObject.get();
        testObject.texta.set("TestText");
        Assert.assertEquals("TestText", testObject.texta.getText());
    }

    @Test
    public void formWebElement() {
        testObject.get();
        Assert.assertTrue(testObject.webElement.isDisplayed());
    }

    @Test
    public void tableRowCount() {
	testObject.get();
	Assert.assertEquals(4, testObject.table.getRowCount());
    }

    @Test
    public void tableColumnCount() {
	testObject.get();
	Assert.assertEquals(2, testObject.table.getColumnCount());
    }

    @Test
    public void tableGetCell() {
	testObject.get();
	Assert.assertEquals("January", testObject.table.getCellAtIndex(2, 0).getText());
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
