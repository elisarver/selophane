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
 * The implementation of a link.
 * @author niels
 *
 */
public class LinkImpl extends ElementImpl implements Link {

    private final WebDriver webDriver;
    
    /**
     * @param elementLocator
     */
    public LinkImpl(UniqueElementLocator elementLocator) {
        super(elementLocator);
        this.webDriver = elementLocator.getWebDriver();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabel() {
        return getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLinkUrl() {
        return getWrappedElement().getAttribute("href");
    }

    @Override
    public void click() {
        final WebDriverWait wait = new WebDriverWait(webDriver, 10);
        final WebElement button = getWrappedElement();
        button.click();
        wait.until(ExpectedConditions.stalenessOf(button));
    }
    
    

}
