package me.selophane.elements.impl.internal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.lang.reflect.InvocationTargetException;

/**
 */
public class ElementFactory extends PageFactory {
    /**
     * Initializes a page factory from a class with a template of
     * Elements.
     *
     * @param driver           WebDriver shared by all tests.
     * @param pageClassToProxy page class to factory-ize.
     * @param <T>              Type of the page being generated.
     * @return an instance of the class initialized.
     */
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        try {
            T page = pageClassToProxy.getConstructor(WebDriver.class).newInstance(driver);
            PageFactory.initElements(new ElementDecorator(new DefaultElementLocatorFactory(driver)), page);
            return page;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
