/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour;

import World.Behaviour.Action.IAction;
import World.Behaviour.Condition.ICondition;
import java.util.Iterator;

/**
 * gives acces to a behavior component.
 * @author jappie
 */
public abstract class SuperBehavior implements IBehavior {
    private IBehavior _behavior;

    public SuperBehavior(IBehavior component) {
	_behavior = component;
    }
    @Override
    public void add(IAction action) {
	_behavior.add(action);
    }

    @Override
    public void add(ICondition condition) {
	_behavior.add(condition);
    }

    @Override
    public void add(IBehavior behavior) {
	_behavior.add(behavior);
    }

    @Override
    public void remove(IAction action) {
	_behavior.remove(action);
    }

    @Override
    public void remove(ICondition condition) {
	_behavior.remove(condition);
    }

    @Override
    public void remove(IBehavior behavior) {
	_behavior.remove(behavior);
    }

    @Override
    public void execute() {
	_behavior.execute();
    }

    @Override
    public void invalidate() {
	_behavior.invalidate();
    }

    @Override
    public boolean isValid() {
	return _behavior.isValid();
    }

    @Override
    public boolean validAction(Iterator executioner) {
	return _behavior.validAction(executioner);
    }

    @Override
    public boolean isHashComputed() {
	return _behavior.isHashComputed();
    }

    @Override
    public boolean isSufficient() {
	return _behavior.isSufficient();
    }

    @Override
    public int hashCode() {
	return _behavior.hashCode();
    }

    @Override
    public boolean equals(Object to) {
	return _behavior.equals(to);
    }
}
