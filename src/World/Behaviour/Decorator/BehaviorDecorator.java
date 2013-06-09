/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.Behaviour.Action.IAction;
import World.Behaviour.Behavior;
import World.Behaviour.Condition.ICondition;
import World.Behaviour.IBehavior;
import java.util.Iterator;

/**
 * 
 * @author jappie
 */
public abstract class BehaviorDecorator extends Behavior{
    private IBehavior _component;
    public BehaviorDecorator(IBehavior component){
	_component = component;
    }

    /**
     * @return the _component
     */
    public IBehavior getComponent() {
	return _component;
    }

    public void add(IAction action) {
	_component.add(action);
    }

    public void add(ICondition condition) {
	_component.add(condition);
    }

    public void add(IBehavior behavior) {
	_component.add(behavior);
    }

    public void remove(IAction action) {
	_component.remove(action);
    }

    public void remove(ICondition condition) {
	_component.remove(condition);
    }

    public void remove(IBehavior behavior) {
	_component.remove(behavior);
    }

    public void execute() {
	_component.execute();
    }

    public void invalidate() {
	_component.invalidate();
    }

    public boolean isValid() {
	return _component.isValid();
    }

    public boolean validAction(Iterator executioner) {
	return _component.validAction(executioner);
    }

    public boolean isHashComputed() {
	return _component.isHashComputed();
    }

    public boolean isSufficient() {
	return _component.isSufficient();
    }
    
        @Override
    public int hashCode() {
	return _component.hashCode();
    }
    
    
    @Override
    public boolean equals(Object to){
	return _component.equals(to);
    }
}
