package org.selophane.elements.factory.api;

import static org.selophane.elements.factory.internal.ImplementedByProcessor.getWrapperClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;
import org.selophane.elements.base.Element;
import org.selophane.elements.base.ElementImpl;
import org.selophane.elements.base.ImplementedBy;
import org.selophane.elements.base.UniqueElementLocator;
import org.selophane.elements.factory.internal.ElementListHandler;
import org.selophane.elements.factory.internal.LocatorWrappingUniqueElementLocator;

/**
 * WrappedElementDecorator recognizes a few things that DefaultFieldDecorator does not.
 * <p/>
 * It is designed to support and return concrete implementations of wrappers for a variety of common html elements.
 */
public class ElementDecorator implements FieldDecorator {
    /**
     * factory to use when generating ElementLocator.
     */
    private ElementLocatorFactory factory;
    
    /**
     * Hold the underlying {@link WebDriver}.
     */
    private final WebDriver webDriver;

    /**
     * Constructor for an ElementLocatorFactory. This class is designed to replace DefaultFieldDecorator.
     *
     * @param webDriver the underlying {@link WebDriver}.
     * @param factory for locating elements.
     */
    public ElementDecorator(WebDriver webDriver, ElementLocatorFactory factory) {
        this.webDriver = webDriver;
        this.factory = factory;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!(WebElement.class.isAssignableFrom(field.getType()) || isDecoratableList(field))) {
            return null;
        }

        if (field.getDeclaringClass() == ElementImpl.class) {
            return null;
        }
        
        ElementLocator locator = factory.createLocator(field);
        if (locator == null) {
            return null;
        }

        Class<?> fieldType = field.getType();
        if (WebElement.class.equals(fieldType)) {
            fieldType = Element.class;
        }

        if (WebElement.class.isAssignableFrom(fieldType)) {
            return getInstance(fieldType, locator);
        } else if (List.class.isAssignableFrom(fieldType)) {
            Class<?> erasureClass = getErasureClass(field);
            return proxyForListLocator(loader, erasureClass, locator);
        } else {
            return null;
        }
    }

    private Class<?> getErasureClass(Field field) {
        // Type erasure in Java isn't complete. Attempt to discover the generic
        // interfaceType of the list.
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }
        return (Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
    }

    private boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }

        Class<?> erasureClass = getErasureClass(field);
        if (erasureClass == null) {
            return false;
        }

        if (!WebElement.class.isAssignableFrom(erasureClass)) {
            return false;
        }

        if (field.getAnnotation(FindBy.class) == null && field.getAnnotation(FindBys.class) == null) {
            return false;
        }

        return true;
    }

    /**
     * Creates an instance of the sublcass of {@link ElementImpl}. 
     * @param interfaceType Interface wrapping the underlying WebElement
     * @param locator       ElementLocator pointing at a proxy of the object on the page
     *
     * @param <T>           The interface of the class.
     * @return a an instance which wrappes the locator.
     */
    @SuppressWarnings("unchecked")
    private <T> T getInstance(Class<T> interfaceType, final ElementLocator locator)  {
        try {
            final Class<?> wrappingType = getWrapperClass(interfaceType);
            final Constructor<?> cons = wrappingType.getConstructor(UniqueElementLocator.class);
            return (T)cons.newInstance(new LocatorWrappingUniqueElementLocator(webDriver, locator));
        } catch (Exception e) {
            throw new IllegalStateException("Can't create instance of " + interfaceType.getName(), e);
        }
    }

    /**
     * generates a proxy for a list of elements to be wrapped.
     *
     * @param loader        classloader for the class we're presently wrapping with proxies
     * @param interfaceType type of the element to be wrapped
     * @param locator       locator for items on the page being wrapped
     * @param <T>           class of the interface.
     * @return proxy with the same type as we started with.
     */
    @SuppressWarnings("unchecked")
    protected <T> List<T> proxyForListLocator(ClassLoader loader, Class<T> interfaceType, ElementLocator locator) {
        InvocationHandler handler;
        if (interfaceType.getAnnotation(ImplementedBy.class) != null) {
            handler = new ElementListHandler(interfaceType, webDriver, locator);
        } else {
            handler = new LocatingElementListHandler(locator);
        }
        List<T> proxy;
        proxy = (List<T>) Proxy.newProxyInstance(
                loader, new Class[]{List.class}, handler);
        return proxy;
    }
}
