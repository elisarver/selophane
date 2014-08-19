package org.selophane.elements.helpers;

import org.selophane.elements.*;
import org.selophane.elements.impl.internal.ElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * declare elements of a form.
 */
public class FormTestObject {

    private WebDriver driver;

    public TextInput texta;

    @FindBy(id = "test1")
    public Element element;

    @FindBy(id = "test1")
    public WebElement webElement;

    @FindBy(id = SelectFragment.ID_LOCATOR)
    public SelectFragment selectFragment;

    @FindBy(id = "checkbox")
    public CheckBox checkbox;
    
    @FindBy(id = "table")
    public Table table;

    @FindBy(tagName = "label")
    public List<Label> labels;

    @FindBy(tagName = "label")
    public List<Element> elementLabels;

    @FindBy(tagName = "label")
    public List<WebElement> webElementLabels;

    @FindBy(css = "label[for='textb']")
    public WebElement labelForTextB;

    public FormTestObject(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Static factory for generating the class.
     *
     * @param driver The WebDriver for the session.
     * @return FormTestObject.
     */
    public static FormTestObject initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, FormTestObject.class);
    }

    public void get() {
        PageLoader.get(driver, "forms.html");
    }

    public void close() {
        driver.close();
    }

}
