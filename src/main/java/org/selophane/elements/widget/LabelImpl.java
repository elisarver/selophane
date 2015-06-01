package org.selophane.elements.widget;

import org.selophane.elements.base.ElementImpl;
import org.selophane.elements.base.UniqueElementLocator;

/**
 * Wraps a label on a html form with some behavior.
 */
public class LabelImpl extends ElementImpl implements Label {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param elementLocator the locator of the webelement.
     */
    public LabelImpl(final UniqueElementLocator elementLocator) {
        super(elementLocator);
    }

    @Override
    public String getFor() {
        return getWrappedElement().getAttribute("for");
    }
}
