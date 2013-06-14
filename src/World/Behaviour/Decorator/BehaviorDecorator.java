/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.Behaviour.Action.IAction;
import World.Behaviour.Behavior;
import World.Behaviour.Condition.ICondition;
import World.Behaviour.IBehavior;
import World.Behaviour.SuperBehavior;

/**
 * this little class makes the behavior pattern way more flexible.
 * @author jappie
 */
public abstract class BehaviorDecorator extends SuperBehavior {

    private IBehavior _component;
    
    /**
     * alows decoration of basic actions by wrapping them inside a behavior.
     * so the actions suffice to the IBehvior interface
     * @param components 
     */
    public BehaviorDecorator(IAction ... components){
	this(new Behavior(components));
    }
    
    /**
     * allows decoration of condition by wrapping them inside a behavior
     * @param components 
     */
    public BehaviorDecorator(ICondition ... components){
	this(new Behavior(components));
    }

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
