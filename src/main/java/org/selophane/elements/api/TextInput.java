package org.selophane.elements.api;

import org.selophane.elementfactory.api.ImplementedBy;
import org.selophane.elements.api.impl.TextInputImpl;

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
