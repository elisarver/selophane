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
	 * Creates a Element for a given WebElement.
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
	
	private List<WebElement> getBodyRows() {
		return findElements(By.cssSelector("tbody tr"));
	}

	private List<WebElement> getRows() {
		return findElements(By.cssSelector("tr"));
	}

	private List<WebElement> getColumnsForRow(WebElement row) {
		return row.findElements(By.tagName("td"));
	}

	
}
