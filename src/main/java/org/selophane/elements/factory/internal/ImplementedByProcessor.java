package org.selophane.elements.factory.internal;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;

/**
 * Processes the iface type into a useful class reference for wrapping WebElements.
 */
public final class ImplementedByProcessor {
    private ImplementedByProcessor() {
    }

    /**
     * Gets the wrapper class (descended from ElementImpl) for the annotation @ImplementedBy.
     *
     * @param iface iface to process for annotations
     * @param <T>   type of the wrapped class.
     * @return The class name of the class in question
     */
    public static <T> Class<?> getWrapperClass(Class<T> iface) {
        if (iface.isAnnotationPresent(ImplementedBy.class)) {
            ImplementedBy annotation = iface.getAnnotation(ImplementedBy.class);
            Class<?> clazz = annotation.value();
            if (Element.class.isAssignableFrom(clazz)) {
                return annotation.value();
            }
        }
        throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface " + 
                iface.getCanonicalName() + " if you want to extend ");
    }

}
