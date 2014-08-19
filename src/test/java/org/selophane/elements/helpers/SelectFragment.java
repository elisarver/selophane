/**
 * 
 */
package org.selophane.elements.helpers;

import org.selophane.elements.Element;
import org.selophane.elements.Select;
import org.selophane.elements.impl.internal.ImplementedBy;

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
