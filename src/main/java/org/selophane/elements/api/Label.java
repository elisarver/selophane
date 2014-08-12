package org.selophane.elements.api;

import org.selophane.elementfactory.api.ImplementedBy;
import org.selophane.elements.api.impl.LabelImpl;

/**
 * Html form label.
 */
@ImplementedBy(LabelImpl.class)
public interface Label extends Element {
    /**
     * Gets the for attribute on the label.
     *
     * @return string containing value of the for attribute, null if empty.
     */
    String getFor();
}
