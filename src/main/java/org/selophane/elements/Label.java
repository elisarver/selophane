package org.selophane.elements;

import org.selophane.elements.impl.LabelImpl;
import org.selophane.elements.impl.internal.ImplementedBy;

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
