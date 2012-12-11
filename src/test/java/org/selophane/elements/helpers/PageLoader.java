package org.selophane.elements.helpers;

import org.openqa.selenium.WebDriver;

import java.net.URL;

public final class PageLoader {
    private PageLoader() {
    }

    /**
     * Get a page by its name. page is stored in test resources.
     *
     * @param driver   WebDriver fed in by the test.
     * @param resource String containing the name of your test html.
     */
    public static void get(WebDriver driver, String resource) {
        URL formsHtmlUrl = PageLoader.class.getClassLoader().getResource(resource);
        if (formsHtmlUrl == null) {
            throw new RuntimeException();
        }
        driver.get(formsHtmlUrl.toString());
    }
}
