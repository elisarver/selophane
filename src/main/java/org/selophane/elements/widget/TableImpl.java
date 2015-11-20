package org.selophane.elements.widget;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selophane.elements.base.ElementImpl;

/**
 * Table wrapper.
 */
public class TableImpl extends ElementImpl implements Table {
    /**
     * Creates a Table for a given WebElement.
     * 
     * @param element
     *            element to wrap up
     */
    public TableImpl(WebElement element) {
        super(element);
    }
    
    @Override
    public int getRowCount() {
        return getRows().size();
    }
    
    @Override
    public int getColumnCount() {
        
        return findElement(By.cssSelector("tr")).findElements(By.cssSelector("*")).size();
        // Would ideally do:
        // return findElements(By.cssSelector("tr:first-of-type > *"));
        // however HTMLUnitDriver does not support CSS3
    }
    
    @Override
    public WebElement getCellAtIndex(int rowIdx, int colIdx) {
        // Get the row at the specified index
        WebElement row = getRows().get(rowIdx);
        
        List<WebElement> cells;
        
        // Cells are most likely to be td tags
        if ((cells = row.findElements(By.tagName("td"))).size() > 0) {
            return cells.get(colIdx);
        }
        // Failing that try th tags
        else if ((cells = row.findElements(By.tagName("th"))).size() > 0) {
            return cells.get(colIdx);
        }
        else {
            final String error = String.format("Could not find cell at row: %s column: %s", rowIdx, colIdx);
            throw new RuntimeException(error);
        }
    }
    
    /**
     * Added a method in implementation class that the interface doesn't have. What if someone wants to extend table and add additional
     * functionality (like I do here)
     * 
     * @param column
     *            index
     */
    public void clickColumnToSort(int column) {
        String INVALID_HEADER_LOC_MSG = "Unable to retrieve header data using locator %s in the context of thead>tr>th";
        final String SORT_COLUMN_HEADER_LOC = "thead>tr>th:nth-of-type(%d)";
        
        WebElement header = findElement(By.cssSelector(String.format(SORT_COLUMN_HEADER_LOC, column)));
        
        if (header != null) {
            header.click();
        }
        else {
            final String error = String.format(INVALID_HEADER_LOC_MSG, getWrappedElement());
            throw new RuntimeException(error);
        }
    }
    
    /**
     * Gets all rows in the table in order header > body > footer
     * 
     * @return list of row WebElements
     */
    private List<WebElement> getRows() {
        List<WebElement> rows = new ArrayList<WebElement>();
        
        //Header rows
        rows.addAll(findElements(By.cssSelector("thead tr")));
        
        //Body rows
        rows.addAll(findElements(By.cssSelector("tbody tr")));
        
        //Footer rows
        rows.addAll(findElements(By.cssSelector("tfoot tr")));
        
        return rows;
    }
    
}
