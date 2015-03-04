package org.selophane.elements.widget;

import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.selophane.elements.base.ElementImpl;

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
     * Select all options that have a value matching the argument. That is, when
     * given "foo" this would select an option like:
     * 
     * &lt;option value="foo"&gt;Bar&lt;/option&gt;
     * 
     * @param value The value to match against
     * @throws NoSuchElementException If no matching option elements are found
     *             or the elements are not visible or disabled.
     */
    public void selectByValue(String value) {
        StringBuilder builder = new StringBuilder(".//option[@value = ");
        builder.append(escapeQuotes(value));
        builder.append("]");
        List<WebElement> options =
                getWrappedElement().findElements(By.xpath(builder.toString()));

        boolean matched = false;
        for (WebElement option : options) {
            if (option.isEnabled() && option.isDisplayed()) {
                setSelected(option);
                if (!isMultiple()) {
                    return;
                }
                matched = true;
            }
        }

        if (!matched) {
            throw new NoSuchElementException(
                    "Cannot locate option with value: " + value);
        }
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
     * Select all options that display text matching the argument. That is, when
     * given "Bar" this would select an option like:
     * 
     * &lt;option value="foo"&gt;Bar&lt;/option&gt;
     * 
     * @param text The visible text to match against
     * @throws NoSuchElementException If no matching option elements are found
     *             or the elements are not visible or disabled.
     * @see org.openqa.selenium.support.ui.Select#selectByVisibleText(String)
     */
    public void selectByVisibleText(String text) {
        final WebElement element = getWrappedElement();
        // try to find the option via XPATH ...
        List<WebElement> options =
                element.findElements(By.xpath(".//option[normalize-space(.) = "
                        + escapeQuotes(text) + "]"));

        boolean matched = false;
        for (WebElement option : options) {
            if (option.isDisplayed() && option.isEnabled()) {
                setSelected(option);
                if (!isMultiple()) {
                    return;
                }
                matched = true;
            }
        }

        if (options.isEmpty() && text.contains(" ")) {
            String subStringWithoutSpace =
                    getLongestSubstringWithoutSpace(text);
            List<WebElement> candidates;
            if ("".equals(subStringWithoutSpace)) {
                // hmm, text is either empty or contains only spaces - get all
                // options ...
                candidates = element.findElements(By.tagName("option"));
            } else {
                // get candidates via XPATH ...
                candidates =
                        element.findElements(By.xpath(".//option[contains(., "
                                + escapeQuotes(subStringWithoutSpace) + ")]"));
            }
            for (WebElement option : candidates) {
                if (option.isEnabled() && text.equals(option.getText())) {
                    setSelected(option);
                    if (!isMultiple()) {
                        return;
                    }
                    matched = true;
                }
            }
        }

        if (!matched) {
            throw new NoSuchElementException(
                    "Cannot locate element with text: " + text);
        }
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
     * Select the option at the given index. This is done by examing the "index"
     * attribute of an element, and not merely by counting.
     * 
     * @param index The option at this index will be selected
     * @throws NoSuchElementException If no matching option elements are found
     *             or the elements are not visible or disabled.
     * @see org.openqa.selenium.support.ui.Select#selectByIndex(int)
     */
    public void selectByIndex(int index) {
        String match = String.valueOf(index);

        boolean matched = false;
        for (WebElement option : getOptions()) {
            if (match.equals(option.getAttribute("index"))
                    && option.isEnabled() && option.isDisplayed()) {
                setSelected(option);
                if (!isMultiple()) {
                    return;
                }
                matched = true;
            }
        }
        if (!matched) {
            throw new NoSuchElementException(
                    "Cannot locate option with index: " + index);
        }
    }

    private String escapeQuotes(String toEscape) {
        // Convert strings with both quotes and ticks into: foo'"bar ->
        // concat("foo'", '"', "bar")
        if (toEscape.indexOf("\"") > -1 && toEscape.indexOf("'") > -1) {
            boolean quoteIsLast = false;
            if (toEscape.lastIndexOf("\"") == toEscape.length() - 1) {
                quoteIsLast = true;
            }
            String[] substrings = toEscape.split("\"");

            StringBuilder quoted = new StringBuilder("concat(");
            for (int i = 0; i < substrings.length; i++) {
                quoted.append("\"").append(substrings[i]).append("\"");
                quoted.append(((i == substrings.length - 1) ? (quoteIsLast ? ", '\"')"
                        : ")")
                        : ", '\"', "));
            }
            return quoted.toString();
        }

        // Escape string with just a quote into being single quoted:
        // f"oo -> 'f"oo'
        if (toEscape.indexOf("\"") > -1) {
            return String.format("'%s'", toEscape);
        }

        // Otherwise return the quoted string
        return String.format("\"%s\"", toEscape);
    }

    private void setSelected(WebElement option) {
        if (!option.isSelected()) {
            option.click();
        }
    }

    private String getLongestSubstringWithoutSpace(String s) {
        String result = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (t.length() > result.length()) {
                result = t;
            }
        }
        return result;
    }
}
