package org.selophane.elements.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

/**
 * An implementation of the Element interface. Delegates its work to an underlying WebElement instance for
 * custom functionality.
 */
public class ElementImpl implements Element {

    private final UniqueElementLocator uniqueElementLocator;

    /**
     * Creates a Element for a given {@link UniqueElementLocator}.
     *
     * @param elementLocator the locator of the webelement.
     */
    public ElementImpl(final UniqueElementLocator elementLocator) {
        this.uniqueElementLocator = elementLocator;
    }

    /**
     * @return the element
     */
    private WebElement getElement() {
        return uniqueElementLocator.findElement();
    }
    
    @Override
    public void click() {
        getElement().click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        getElement().sendKeys(keysToSend);
    }

    @Override
    public Point getLocation() {
        return getElement().getLocation();
    }

    @Override
    public void submit() {
        getElement().submit();
    }

    @Override
    public String getAttribute(String name) {
        return getElement().getAttribute(name);
    }

    @Override
    public String getCssValue(String propertyName) {
        return getElement().getCssValue(propertyName);
    }

    @Override
    public Dimension getSize() {
        return getElement().getSize();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    @Override
    public String getText() {
        return getElement().getText();
    }

    @Override
    public String getTagName() {
        return getElement().getTagName();
    }

    @Override
    public boolean isSelected() {
        return getElement().isSelected();
    }

    @Override
    public WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    @Override
    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    @Override
    public void clear() {
        getElement().clear();
    }

    @Override
    public WebElement getWrappedElement() {
        return getElement();
    }

    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) getElement()).getCoordinates();
    }

    @Override
    public boolean elementWired() {
        return (getElement() != null);
    }

}
