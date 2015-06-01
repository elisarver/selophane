/**
 * 
 */
package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

/**
 * Representation of a link which ensures that the page is reloaded after a click 
 * on it or more general a link that starts an action so that
 * this link will at the end of the action not in the DOM.
 * @author niels
 *
 */
@ImplementedBy(LinkImpl.class)
public interface Link extends Element {
    /**
     * Return the label of the link.
     * @return the label of the link.
     */
    String getLabel();
    
    /**
     * Click the link and wait till this button is removed from current DOM.
     * {@inheritDoc}
     */
    void click();
    
    /**
     * Get the url of the link.
     * @return the url of the link.
     */
    String getLinkUrl();
}
