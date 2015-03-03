package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element {
    /**
     * @param text The text to type into the field.
     */
    void set(String text);
}
