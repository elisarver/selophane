package org.selophane.elements.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sets the default implementing class for the annotated interface.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {
    /**
     * Class implementing the interface. (by default)
     */
    Class<?> value() default ElementImpl.class;
}
