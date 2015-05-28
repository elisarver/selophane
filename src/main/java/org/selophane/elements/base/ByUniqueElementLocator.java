/**
 * 
 */
package org.selophane.elements.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A uniqueElementlocator which finds the element with a {@link By} Defnition.
 * @author niels
 *
 */
public class ByUniqueElementLocator implements UniqueElementLocator {

    /**
     * The underlying webdriver.
     */
    private final WebDriver webDriver;
    
    /**
     * A {@link By} expression to find the element, which should be unique.
     */
    private final By locator;
    
    /**
     * Create a new instance.
     * @param webDriver the underlying webdriver.
     * @param locator A {@link By} expression to find the element, which should be unique.
     */
    public ByUniqueElementLocator(WebDriver webDriver, By locator) {
        this.webDriver = webDriver;
        this.locator = locator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebElement findElement() {        
        return webDriver.findElement(locator);
    }

}
