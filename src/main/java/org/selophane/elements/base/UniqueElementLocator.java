package org.selophane.elements.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A locator for a {@link WebElement} which only return one  element.
 * @author niels
 *
 */
public interface  UniqueElementLocator {
    
    /**
     * Returns the underlying {@link WebDriver}.
     * @return the underlying {@link WebDriver}.
     */
    WebDriver getWebDriver();
    
    /**
     * Finds a element.
     * @return the element.
     */
    WebElement findElement();
}
