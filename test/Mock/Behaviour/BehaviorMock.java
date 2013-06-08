/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock.Behaviour;

import Behaviour.Action.IAction;
import Behaviour.Condition.ICondition;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class BehaviorMock extends ValidationMock implements IBehavior {
    
    public IAction _addedAction, _removedAction;
    public ICondition _addedCondition, _removedCondition;
    public IBehavior _addedBehavior, _removedBehavior;
    
    public boolean 
	    _isSufficient = true, 
	    _executionValue = true,
	    _isExecuted = false;

    public void add(IAction action) {
	_addedAction = action;
    }

    public void add(ICondition condition) {
	_addedCondition = condition;
    }

    public void add(IBehavior behavior) {
	_addedBehavior = behavior;
    }

    public void remove(IAction action) {
	_removedAction = action;
    }

    public void remove(ICondition condition) {
	_removedCondition = condition;
    }

    public void remove(IBehavior behavior) {
	_removedBehavior = behavior;
    }

    public void execute() {
	_isExecuted = _executionValue;
    }

    public boolean isSufficient() {
	return _isSufficient;
    }
    @Override
    public boolean equals(Object to){
	return (to instanceof BehaviorMock);
    }

    @Override
    public int hashCode() {
	return 1;
    }
    
}
