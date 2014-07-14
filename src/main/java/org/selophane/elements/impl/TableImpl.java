package org.selophane.elements.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selophane.elements.Table;

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
		WebElement bodyRow = getBodyRows().get(0);
		return getColumnsForRow(bodyRow).size();
	}

	@Override
	public WebElement getCellAtIndex(int rowIdx, int colIdx) {
		WebElement row = getRows().get(rowIdx);
		return getColumnsForRow(row).get(colIdx);
	}

	/**
	 * Gets the rows within the tbody tag
	 * @return List of body row WebElements
	 */
	private List<WebElement> getBodyRows() {
		return findElements(By.cssSelector("tbody tr"));
	}

	/**
	 * Gets all rows in the table
	 * @return list of row WebElements
	 */
	private List<WebElement> getRows() {
		return findElements(By.cssSelector("tr"));
	}

	/**
	 * Gets the columns in the specified row
	 * @param row WebElement of the row
	 * @return List of column WebElements
	 */
	private List<WebElement> getColumnsForRow(WebElement row) {
		return row.findElements(By.tagName("td"));
	}


}
