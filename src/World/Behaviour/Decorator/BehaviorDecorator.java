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
}
