/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class ValidOnce extends BehaviorDecorator {
    
    /**
     * 
     * @param component the component which will only be valid once
     */
    public ValidOnce(IBehavior component){
	super(component);
    }
    
    @Override
    public boolean isValid() {
	boolean isValid = getComponent().isValid();
	getComponent().invalidate();
	return isValid;
    }
    
}
