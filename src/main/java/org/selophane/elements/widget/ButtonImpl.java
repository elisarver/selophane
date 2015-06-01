/**
 * 
 */
package org.selophane.elements.widget;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selophane.elements.base.ElementImpl;
import org.selophane.elements.base.UniqueElementLocator;

/**
 * Implementation of a button that starts an action so that
 * this button will at the end of the action not in the DOM.
 * @author niels
 *
 */
public class ButtonImpl extends ElementImpl implements Button {

    private final WebDriver webDriver;
    
    /**
     * Creates a new instance.
     * @param elementLocator locator to get the underlying webelement.
     */
    public ButtonImpl(UniqueElementLocator elementLocator) {
        super(elementLocator);
        this.webDriver = elementLocator.getWebDriver();
    }

    @Override
    public void click() {
        final WebDriverWait wait = new WebDriverWait(webDriver, 10);
        final WebElement button = getWrappedElement();
        button.click();
        wait.until(ExpectedConditions.stalenessOf(button));
    }

    @Override
    public String getLabel() {
        return getText();
    }
    
    

}
