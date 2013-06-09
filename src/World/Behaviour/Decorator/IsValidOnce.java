/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.IValid;

/**
 *
 * @author jappie
 */
public class IsValidOnce extends IsValidDecorator {
    
    /**
     * 
     * @param component the component which will only be valid once
     */
    public IsValidOnce(IValid component){
	super(component);
    }

    @Override
    boolean isValidExtension() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
