package org.selophane.elements.factory.api;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.selophane.elements.base.UniqueElementLocator;

/**
 * {@link ElementLocatorFactory} which use a {@link ElementLocator} instead of 
 * a {@link SearchContext}.
 * @author niels
 *
 */
//TODO AJAX-Variant.
public class ChainedElementLocatorFactory implements ElementLocatorFactory {

    private final UniqueElementLocator elementLocator;
    
    
    /**
     * New instance.
     * @param elementLocator {@link ElementLocator} which defines the {@link WebElement} as base for a search.
     * @param pos the position which elements of the {@link ElementLocator} should be used.
     */
    public ChainedElementLocatorFactory(UniqueElementLocator elementLocator) {
        this.elementLocator = elementLocator;
    }



    @Override
    public ElementLocator createLocator(Field field) {
        return new ChainedElementLocator(elementLocator, field);
    }
    
    private final static class ChainedElementLocator implements ElementLocator {
        private final UniqueElementLocator elementLocator;
        private final boolean shouldCache;
        private final By by;
        private WebElement cachedElement;
        private List<WebElement> cachedElementList;
        
        /**
         * Creates a new element locator.
         * 
         * @param elementLocator a elementLocator
         * @param field The field on the Page Object that will hold the located value
         */
        public ChainedElementLocator(UniqueElementLocator elementLocator, Field field) {
          this.elementLocator= elementLocator;
          Annotations annotations = new Annotations(field);
          shouldCache = annotations.isLookupCached();
          by = annotations.buildBy();
        }

        /**
         * Find the element.
         */
        public WebElement findElement() {
          if (cachedElement != null && shouldCache) {
            return cachedElement;
          }

          WebElement element = elementLocator.findElement().findElement(by);
          if (shouldCache) {
            cachedElement = element;
          }

          return element;
        }

        /**
         * Find the element list.
         */
        public List<WebElement> findElements() {
          if (cachedElementList != null && shouldCache) {
            return cachedElementList;
          }

          List<WebElement> elements = elementLocator.findElement().findElements(by);
          if (shouldCache) {
            cachedElementList = elements;
          }

          return elements;
        }

    }
    
    

}
