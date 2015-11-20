package org.selophane.elements;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.factory.api.ElementFactory;
import org.selophane.elements.widget.Table;
import org.selophane.elements.widget.TableImpl;

@RunWith(JUnit4.class)
public class TableTest {
    
    static WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        driver = new HtmlUnitDriver();
    }

    @FindBy(id = "table2")
    Table sortableTable;

    @Test
    public void testClickColumnToSort() {
        TableTest testPage = ElementFactory.initElements(driver, TableTest.class);
        //Note: sortableTable is interface, but we need the implementations method "clickColumnToSort,
        //so trying to cast it throws ClassCastException
        TableImpl base = (TableImpl) testPage.sortableTable;
        base.clickColumnToSort(1);
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
