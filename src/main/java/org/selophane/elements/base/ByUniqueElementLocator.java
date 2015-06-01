/**
 * 
 */
package org.selophane.elements.base;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
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
    
    private final SearchContext searchContext;
    
    
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
        this(webDriver, webDriver, locator);
    }
    

    /**
     * create a new instance.
     * @param webDriver the webdriver
     * @param searchContext a special {@link SearchContext}, on which the 
     *  locator should work.
     * @param locator the locator
     */
    public ByUniqueElementLocator(WebDriver webDriver,
            SearchContext searchContext, By locator) {
        super();
        this.webDriver = webDriver;
        this.searchContext = searchContext;
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
        return searchContext.findElement(locator);
    }

}
