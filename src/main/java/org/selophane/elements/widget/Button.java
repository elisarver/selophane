/**
 * 
 */
package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

/**
 * A button which ensures that the page is reloaded after a click on it or more
 * general a button that starts an action so that
 * this button will at the end of the action not in the DOM.
 * @author niels
 *
 */
@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {
    
    /**
     * Return the label of the button.
     * @return the label of the button.
     */
    String getLabel();
    
    /**
     * Click the button and wait till this button is removed from current DOM.
     * {@inheritDoc}
     */
    void click();

}
