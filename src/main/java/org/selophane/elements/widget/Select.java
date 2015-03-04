package org.selophane.elements.widget;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Interface for a select element.
 */
@ImplementedBy(SelectImpl.class)
public interface Select extends Element {

    /**
     * Wraps Selenium's method.
     *
     * @return boolean if this is a multiselect.
     * @see org.openqa.selenium.support.ui.Select#isMultiple()
     */
    boolean isMultiple();

    /**
     * Wraps Selenium's method.
     *
     * @param index index to select
     * @see org.openqa.selenium.support.ui.Select#deselectByIndex(int)
     */
    void deselectByIndex(int index);

    /**
     * Wraps Selenium's method.
     *
     * @param value the value to select.
     * @see org.openqa.selenium.support.ui.Select#selectByValue(String)
     */
    void selectByValue(String value);

    /**
     * Wraps Selenium's method.
     *
     * @return WebElement of the first selected option.
     * @see org.openqa.selenium.support.ui.Select#getFirstSelectedOption()
     */
    WebElement getFirstSelectedOption();

    /**
     * Wraps Selenium's method.
     *
     * @param text visible text to select
     * @see org.openqa.selenium.support.ui.Select#selectByVisibleText(String)
     */
    void selectByVisibleText(String text);

    /**
     * Wraps Selenium's method.
     *
     * @param value value to deselect
     * @see org.openqa.selenium.support.ui.Select#deselectByValue(String)
     */
    void deselectByValue(String value);

    /**
     * Wraps Selenium's method.
     *
     * @see org.openqa.selenium.support.ui.Select#deselectAll()
     */
    void deselectAll();

    /**
     * Wraps Selenium's method.
     *
     * @return List of WebElements selected in the select
     * @see org.openqa.selenium.support.ui.Select#getAllSelectedOptions()
     */
    List<WebElement> getAllSelectedOptions();

    /**
     * Wraps Selenium's method.
     *
     * @return list of all options in the select.
     * @see org.openqa.selenium.support.ui.Select#getOptions()
     */
    List<WebElement> getOptions();

    /**
     * Wraps Selenium's method.
     *
     * @param text text to deselect by visible text
     * @see org.openqa.selenium.support.ui.Select#deselectByVisibleText(String)
     */
    void deselectByVisibleText(String text);

    /**
     * Wraps Selenium's method.
     *
     * @param index index to select
     * @see org.openqa.selenium.support.ui.Select#selectByIndex(int)
     */
    void selectByIndex(int index);

}
