package org.selophane.elements.widget;

import org.selophane.elements.base.ElementImpl;
import org.selophane.elements.base.UniqueElementLocator;

/**
 * Wrapper class like Select that wraps basic checkbox functionality.
 */
public class CheckBoxImpl extends ElementImpl implements CheckBox {

    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param elementLocator the locator of the webelement.
     */
    public CheckBoxImpl(final UniqueElementLocator elementLocator) {
        super(elementLocator);
    }

    public void toggle() {
        getWrappedElement().click();
    }

    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }
}
