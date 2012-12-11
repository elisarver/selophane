package org.selophane.elements;

import org.selophane.elements.impl.TextInputImpl;
import org.selophane.elements.impl.internal.ImplementedBy;

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
