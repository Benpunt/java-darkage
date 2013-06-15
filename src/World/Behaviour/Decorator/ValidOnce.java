/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.Behaviour.Action.IAction;
import World.Behaviour.Condition.ICondition;
import World.Behaviour.IBehavior;

/**
 * This decoration only works if there is a super behavior active to remove its component.
 * @author jappie
 */
public class ValidOnce extends BehaviorDecorator {
    
    /**
     * @param component the component which will only be valid once
     */
    public ValidOnce(IBehavior component){
	super(component);
    }
    /**
     * @param component the component which will only be valid once
     */    
    public ValidOnce(ICondition component){
	// perhaps this can different...
	super(component);
    }
    /**
     * @param component the component which will only be valid once
     */
    public ValidOnce(IAction component){
	super(component);
    }
    
    /**
     * overides in such a way that the component wil be invalid next cycle
     * @return 
     */
    @Override
    public boolean isValid() {
	boolean isValid = getComponent().isValid();
	getComponent().invalidate();
	return isValid;
    }
    
}
