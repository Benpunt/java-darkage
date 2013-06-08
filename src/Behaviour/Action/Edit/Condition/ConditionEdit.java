/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Condition;

import Behaviour.Action.Edit.Edit;
import Behaviour.Action.IAction;
import Behaviour.Condition.ICondition;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public abstract class ConditionEdit extends Edit  implements IAction {
    private ICondition _target;
    protected ConditionEdit(IBehavior from, ICondition target){
	super(from);
	_target = target;
    }

    /**
     * @return the _target
     */
    protected ICondition getTarget() {
	return _target;
    }
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof ConditionEdit)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	int hash = super.hashCode();
	hash = 97 * hash + (this._target != null ? this._target.hashCode() : 0);
	return hash;
    }
}
