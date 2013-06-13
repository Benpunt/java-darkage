/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.Behaviour.IBehavior;
import World.Behaviour.SuperBehavior;

/**
 *
 * @author jappie
 */
public abstract class BehaviorDecorator extends SuperBehavior {

    private IBehavior _component;

    public BehaviorDecorator(IBehavior component) {
	super(component);
	_component = component; // behavior decorator needs acces to the behavior
    }

    /**
     * @return the _component
     */
    public IBehavior getComponent() {
	return _component;
    }
    
        @Override
    public boolean equals(Object to){
	if(!(to instanceof BehaviorDecorator)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	return (super.hashCode() * 79) * _component.hashCode();
    }
}
