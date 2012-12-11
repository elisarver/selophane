package org.selophane.elements;

import junit.framework.Assert;
import org.selophane.elements.helpers.FormTestObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.InvocationTargetException;

/**
 * Test the form element types.
 */
@RunWith(JUnit4.class)
public class FormTest {

    public static FormTestObject preamble() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        WebDriver driver = new FirefoxDriver();
        FormTestObject testObject = FormTestObject.initialize(driver);
        return testObject;
    }

    @Test
    public void isChecked() throws Throwable {
        FormTestObject testObject = preamble();
        testObject.get();
        Assert.assertFalse(testObject.checkbox.isChecked());
        testObject.close();
    }

    @Test
    public void check() throws Throwable {
        FormTestObject testObject = preamble();
        testObject.get();
        testObject.checkbox.check();
        Assert.assertTrue(testObject.checkbox.isChecked());
        testObject.close();
    }

    @Test
    public void uncheck() throws Throwable {
        FormTestObject testObject = preamble();
        testObject.get();
        testObject.checkbox.click();
        testObject.checkbox.uncheck();
        Assert.assertFalse(testObject.checkbox.isChecked());
        testObject.close();
    }

    @Test
    public void selectWiredProperly() throws Throwable {
        FormTestObject testObject = preamble();
        testObject.get();
        testObject.option1.selectByIndex(0);
        Assert.assertEquals(1, testObject.option1.getAllSelectedOptions().size());
        testObject.close();
    }

    @Test
    public void getLabelsList() throws Throwable {
        FormTestObject testObject = preamble();
        testObject.get();
        for (Label label : testObject.labels) {
            Assert.assertNotNull(label.getFor());
        }
        testObject.close();
    }

    @Test
    public void formElement() throws Throwable {
        FormTestObject testObject = preamble();
        testObject.get();
        Assert.assertTrue(testObject.element.elementWired());
        testObject.close();
    }

    @Test
    public void formWebElement() throws Throwable {
        FormTestObject testObject = preamble();
        testObject.get();
        Assert.assertTrue(testObject.webElement.isDisplayed());
        testObject.close();
    }
}
