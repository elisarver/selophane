/**
 * 
 */
package org.selophane.elements.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selophane.elementfactory.api.ElementFactory;
import org.selophane.elements.api.Select;
import org.selophane.elements.api.impl.ElementImpl;

/**
 * @author niels
 *
 */
public class SelectFragmentImpl extends ElementImpl implements SelectFragment {

    
    @FindBy(id = "option1")
    private Select option1;
    
    public SelectFragmentImpl(WebElement element) {
        super(element);
        ElementFactory.initElements(element, this);
    }

    @Override
    public Select getOption1() {
        return option1;
    }

}
