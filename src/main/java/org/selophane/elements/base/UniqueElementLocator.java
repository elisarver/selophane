package org.selophane.elements.base;

import org.openqa.selenium.WebElement;

/**
 * A locator for a {@link WebElement} which only return one  element.
 * @author niels
 *
 */
public interface  UniqueElementLocator {
    
    /**
     * Finds a element.
     * @return the element.
     */
    WebElement findElement();
}
