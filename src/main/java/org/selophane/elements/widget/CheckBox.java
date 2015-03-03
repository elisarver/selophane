package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

/**
 * Interface that wraps a WebElement in CheckBox functionality.
 */
@ImplementedBy(CheckBoxImpl.class)
public interface CheckBox extends Element {

    /**
     * Toggle the state of the checkbox.
     */
    void toggle();

    /**
     * Checks checkbox if unchecked.
     */
    void check();

    /**
     * Un-checks checkbox if checked.
     */
    void uncheck();

    /**
     * Check if an element is selected, and return boolean.
     *
     * @return true if check is checked, return false in other case
     */
    boolean isChecked();
}
