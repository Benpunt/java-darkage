/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.Behaviour.Condition.ICondition;
import World.Behaviour.IBehavior;

/**
 * inverses the issuficient method.
 * Only works with a behavior or condition as to constructor implies
 * @author jappie
 */
public class Inverse extends BehaviorDecorator {
    /**
     * @param component the component which will only be inversed
     */
    public Inverse(IBehavior component){
	super(component);
    }
    /**
     * @param component the component which will only be inversed
     */    
    public Inverse(ICondition component){
	// perhaps this can different...
	super(component);
    } 
    
    /**
     * adds a not to the return value of issSufficient from the component
     * @return 
     */
    @Override
    public boolean isSufficient(){
	return !getComponent().isSufficient();
    }
    
}
