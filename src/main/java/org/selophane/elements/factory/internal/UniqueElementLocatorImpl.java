package org.selophane.elements.factory.internal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.selophane.elements.base.UniqueElementLocator;

/**
 * Implementation of a {@link UniqueElementLocator}.
 * @author niels
 *
 */
public class UniqueElementLocatorImpl implements UniqueElementLocator {
    /**
     * Underlying locator.
     */
    private final ElementLocator elementLocator;
    
    /**
     * The underlying {@link WebDriver}.
     */
    private final WebDriver webDriver;
    
    /**
     * Index which elements of {@link ElementLocator#findElements()} should be used. 
     */
    private final int index;

    /**
     * Creates a new element locator.
     * 
     * @param webDriver the underlying webdriver
     * @param elementLocator a elementLocator
     * @param index Index which elements of {@link ElementLocator#findElements()} should be used,
     * if -1 the method {@link ElementLocator#findElement()} is used.
     */
    public UniqueElementLocatorImpl(WebDriver webDriver, ElementLocator elementLocator, int index) {
        this.webDriver = webDriver;
        this.elementLocator = elementLocator;
        this.index = index;
    }
    
    /**
     * Creates a new element locator where the method {@link ElementLocator#findElement()} is used.
     * 
     * @param webDriver the underlying webdriver
     * @param elementLocator a elementLocator
     */
    public UniqueElementLocatorImpl(WebDriver webDriver, ElementLocator elementLocator) {
        this(webDriver, elementLocator, -1);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public WebElement findElement() {
        if (index == -1) {
            return elementLocator.findElement();
        }
        return elementLocator.findElements().get(index);
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

}
