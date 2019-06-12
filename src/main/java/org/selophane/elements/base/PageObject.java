package org.selophane.elements.base;

import org.openqa.selenium.WebDriver;
import org.selophane.elements.factory.api.ElementFactory;

public interface PageObject{

    default <T extends PageObject> T initialize(WebDriver driverz, Class<T> a){
        return ElementFactory.initElements(driverz, a);
    }
}
