package org.selophane.elements.widget;

import org.selophane.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Wrapper around a WebElement for the Select class in Selenium.
 */
public class SelectImpl extends ElementImpl implements Select {
    private final org.openqa.selenium.support.ui.Select innerSelect;

    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param element to wrap up
     */
    public SelectImpl(WebElement element) {
        super(element);
        this.innerSelect = new org.openqa.selenium.support.ui.Select(element);
    }

    /**
     * Wraps Selenium's method.
     *
     * @return boolean if this is a multiselect.
     * @see org.openqa.selenium.support.ui.Select#isMultiple()
     */
    public boolean isMultiple() {
        return innerSelect.isMultiple();
    }

    /**
     * Wraps Selenium's method.
     *
     * @param index index to select
     * @see org.openqa.selenium.support.ui.Select#deselectByIndex(int)
     */
    public void deselectByIndex(int index) {
        innerSelect.deselectByIndex(index);
    }

    /**
     * Wraps Selenium's method.
     *
     * @param value the value to select.
     * @see org.openqa.selenium.support.ui.Select#selectByValue(String)
     */
    public void selectByValue(String value) {
        innerSelect.selectByValue(value);
    }

    /**
     * Wraps Selenium's method.
     *
     * @return WebElement of the first selected option.
     * @see org.openqa.selenium.support.ui.Select#getFirstSelectedOption()
     */
    public WebElement getFirstSelectedOption() {
        return innerSelect.getFirstSelectedOption();
    }

    /**
     * Wraps Selenium's method.
     *
     * @param text visible text to select
     * @see org.openqa.selenium.support.ui.Select#selectByVisibleText(String)
     */
    public void selectByVisibleText(String text) {
        innerSelect.selectByVisibleText(text);
    }

    /**
     * Wraps Selenium's method.
     *
     * @param value value to deselect
     * @see org.openqa.selenium.support.ui.Select#deselectByValue(String)
     */
    public void deselectByValue(String value) {
        innerSelect.deselectByValue(value);
    }

    /**
     * Wraps Selenium's method.
     *
     * @see org.openqa.selenium.support.ui.Select#deselectAll()
     */
    public void deselectAll() {
        innerSelect.deselectAll();
    }

    /**
     * Wraps Selenium's method.
     *
     * @return List of WebElements selected in the select
     * @see org.openqa.selenium.support.ui.Select#getAllSelectedOptions()
     */
    public List<WebElement> getAllSelectedOptions() {
        return innerSelect.getAllSelectedOptions();
    }

    /**
     * Wraps Selenium's method.
     *
     * @return list of all options in the select.
     * @see org.openqa.selenium.support.ui.Select#getOptions()
     */
    public List<WebElement> getOptions() {
        return innerSelect.getOptions();
    }

    /**
     * Wraps Selenium's method.
     *
     * @param text text to deselect by visible text
     * @see org.openqa.selenium.support.ui.Select#deselectByVisibleText(String)
     */
    public void deselectByVisibleText(String text) {
        innerSelect.deselectByVisibleText(text);
    }

    /**
     * Wraps Selenium's method.
     *
     * @param index index to select
     * @see org.openqa.selenium.support.ui.Select#selectByIndex(int)
     */
    public void selectByIndex(int index) {
        innerSelect.selectByIndex(index);
    }
}
