/**
 * 
 */
package org.selophane.elements.helpers;

import org.selophane.elements.base.Element;
import org.selophane.elements.base.ImplementedBy;
import org.selophane.elements.widget.Select;

/**
 * Fragment of options just for demonstration purpose.
 * @author niels
 *
 */
@ImplementedBy(SelectFragmentImpl.class)
public interface SelectFragment extends Element {
    
    final String ID_LOCATOR = "options";
    
    Select getOption1();

}
