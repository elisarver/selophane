package org.selophane.elements;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.selophane.elements.base.Element;
import org.selophane.elements.helpers.FormTestObject;
import org.selophane.elements.widget.Label;

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
    
    @Before
    public void beforeTest() {
    	testObject.get();
    }

    @Test
    public void isChecked() {
        Assert.assertFalse(testObject.checkbox.isChecked());
    }

    @Test
    public void check() {
        testObject.checkbox.check();
        Assert.assertTrue(testObject.checkbox.isChecked());
    }

    @Test
    public void uncheck() {
        testObject.checkbox.click();
        testObject.checkbox.uncheck();
        Assert.assertFalse(testObject.checkbox.isChecked());
    }

    @Test
    public void selectWiredProperly() {
        testObject.selectFragment.getOption1().selectByIndex(0);
        Assert.assertEquals(1, testObject.selectFragment.getOption1().getAllSelectedOptions().size());
        Assert.assertNotNull(testObject.selectFragment.getSubElement(By.id("option1")));
    }

    @Test
    public void getLabelsList() {
        for (Label label : testObject.labels) {
            Assert.assertNotNull(label.getFor());
        }
    }

    @Test
    public void getElementLabelsList() {
        for (Element webElementLabel : testObject.elementLabels) {
            Assert.assertNotNull(webElementLabel.getAttribute("for"));
        }
    }

    @Test
    public void getWebElementLabelsList() {
        for (WebElement webElementLabel : testObject.webElementLabels) {
            Assert.assertNotNull(webElementLabel.getAttribute("for"));
        }
    }

    @Test
    public void getWebElement() {
        Assert.assertTrue(testObject.labelForTextB.isDisplayed());
    }

    @Test
    public void formElement() {
        Assert.assertTrue(testObject.element.elementWired());
    }

    @Test
    public void textInputSet() {
        testObject.texta.set("TestText");
        Assert.assertEquals("TestText", testObject.texta.getAttribute("value"));
    }

    @Test
    public void textInputClear() {
        testObject.texta.set("TestText");
        testObject.texta.clear();
        Assert.assertEquals("", testObject.texta.getAttribute("value"));
    }

    @Test
    public void textInputGetValue() {
        testObject.texta.set("TestText");
        Assert.assertEquals("TestText", testObject.texta.getText());
    }

    @Test
    public void formWebElement() {
        Assert.assertTrue(testObject.webElement.isDisplayed());
    }
    
    @Test
    public void tableRowCount() {
    	Assert.assertEquals(4, testObject.table.getRowCount());
    }
    
    @Test
    public void tableColumnCount() {
    	Assert.assertEquals(2, testObject.table.getColumnCount());
    }
    
    @Test
    public void tableGetHeaderCell() {
    	Assert.assertEquals("Month", testObject.table.getCellAtIndex(0, 0).getText());
    }
    
    @Test
    public void tableGetBodyCell() {
    	Assert.assertEquals("$80", testObject.table.getCellAtIndex(2, 1).getText());
    }
    
    @Test
    public void tableGetFooterCell() {
    	Assert.assertEquals("Sum", testObject.table.getCellAtIndex(3, 0).getText());
    }
    
    @Test(expected=InvalidElementStateException.class)
    public void selectDisabledElement() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        final String disabledOptionText = "Disabled option";
        testObject.option1.selectByVisibleText(disabledOptionText);
    }
    
    @Test(expected=InvalidElementStateException.class)
    public void selectDisabledElementByValue() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByValue("option3");
    }

    
    @Test(expected=InvalidElementStateException.class)
    public void selectDisabledElementByIndex() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByIndex(2);
    }

       
    @Test(expected=NoSuchElementException.class)
    public void selectNonExistingElementSelectByIndex() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByIndex(10);
    }

    @Test(expected=NoSuchElementException.class)
    public void selectNonExistingElementSelectByValue() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByValue("foofoo");
    }

    @Test(expected=NoSuchElementException.class)
    public void selectNonExistingElementSelectByVisibleText() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByVisibleText("fooBar");
    }

    
    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
