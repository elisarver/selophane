package org.selophane.elements.base;

import org.openqa.selenium.WebDriver;
import org.selophane.elements.factory.api.ElementFactory;

public interface PageObject{

    /**
     * Static factory for generating the class.
     *
     * @param driverz The WebDriver for the session.
     * @return FormTestObject.
     */
    default <T extends PageObject> T initialize(WebDriver driverz, Class<T> a){
        return ElementFactory.initElements(driverz, a);
    }
}
