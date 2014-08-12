/**
 * 
 */
package org.selophane.elements.helpers;

import org.selophane.elementfactory.api.ImplementedBy;
import org.selophane.elements.api.Element;
import org.selophane.elements.api.Select;

/**
 * Fragment of options.
 * @author niels
 *
 */
@ImplementedBy(SelectFragmentImpl.class)
public interface SelectFragment extends Element {
    
    final String ID_LOCATOR = "options";
    
    Select getOption1();

}
