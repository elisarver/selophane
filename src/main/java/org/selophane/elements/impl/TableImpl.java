package org.selophane.elements.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selophane.elements.Table;

/**
 * Table wrapper.
 */
public class TableImpl extends ElementImpl implements Table {
	/**
	 * Creates a Table for a given WebElement. <<<<<<< HEAD
	 * 
	 * =======
	 * 
	 * >>>>>>> ee7b5147aebd6355418268cd81b675566b81bdb9
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

		return findElement(By.cssSelector("tr")).findElements(
				By.cssSelector("*")).size();
		// Would ideally do:
		// return findElements(By.cssSelector("tr:first-of-type > *"));
		// however HTMLUnitDriver does not support CSS3
	}

	@Override
	public WebElement getCellAtIndex(int rowIdx, int colIdx) {
		WebElement row = getRows().get(rowIdx);

		List<WebElement> tds;
		List<WebElement> ths;

		if ((tds = row.findElements(By.tagName("td"))).size() > 0) {
			return tds.get(colIdx);
		} else if ((ths = row.findElements(By.tagName("th"))).size() > 0) {
			return ths.get(colIdx);
		} else {
			final String error = String
					.format("Could not find cell at row: %s column: %s",
							rowIdx, colIdx);
			throw new RuntimeException(error);
		}
	}

	/**
	 * Gets all rows in the table in order header > body > footer
	 * 
	 * @return list of row WebElements
	 */
	private List<WebElement> getRows() {
		List<WebElement> headerRows = findElements(By.cssSelector("thead tr"));
		List<WebElement> bodyRows = findElements(By.cssSelector("tbody tr"));
		List<WebElement> footerRows = findElements(By.cssSelector("tfoot tr"));

		List<WebElement> allRows = new ArrayList<WebElement>();
		allRows.addAll(headerRows);
		allRows.addAll(bodyRows);
		allRows.addAll(footerRows);

		return allRows;
	}

}
