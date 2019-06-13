package org.selophane.elements.helpers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.base.Element;
import org.selophane.elements.base.PageObject;
import org.selophane.elements.factory.api.ElementFactory;
import org.selophane.elements.widget.CheckBox;
import org.selophane.elements.widget.Label;
import org.selophane.elements.widget.Select;
import org.selophane.elements.widget.Table;
import org.selophane.elements.widget.TextInput;

/**
 * declare elements of a form.
 */
public class FormTestObject implements PageObject {

    private WebDriver driver;

    public TextInput texta;

    @FindBy(id = "test1")
    public Element element;

    @FindBy(id = "test1")
    public WebElement webElement;
    
    public Select option1;

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

    public void get() {
        PageLoader.get(driver, "forms.html");
    }

    public void close() {
        driver.close();
    }

}
