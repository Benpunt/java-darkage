/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.Behaviour.Decorator.Abstract.IsValidDecorator;
import World.IValid;

/**
 *
 * @author jappie
 */
public class ValidOnce extends IsValidDecorator {
    
    /**
     * 
     * @param component the component which will only be valid once
     */
    public ValidOnce(IValid component){
	super(component);
    }
    
    @Override
    public boolean isValidExtension() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
