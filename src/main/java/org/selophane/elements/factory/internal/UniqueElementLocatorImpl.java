package org.selophane.elements.factory.internal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.selophane.elements.base.UniqueElementLocator;

/**
 * Implementation of a {@link UniqueElementLocator}.
 * @author niels
 *
 */
public class UniqueElementLocatorImpl implements UniqueElementLocator {
    private final ElementLocator elementLocator;
    private final int index;

    /**
     * Creates a new element locator.
     * 
     * @param elementLocator a elementLocator
     * @param field The field on the Page Object that will hold the located
     *            value
     */
    public UniqueElementLocatorImpl(ElementLocator elementLocator, int index) {
        this.elementLocator = elementLocator;
        this.index = index;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public WebElement findElement() {
        return elementLocator.findElements().get(index);
    }

}
