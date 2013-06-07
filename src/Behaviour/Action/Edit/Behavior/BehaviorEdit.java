/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Behavior;

import Behaviour.Action.Edit.Edit;
import Behaviour.Action.IAction;
import Behaviour.IBehavior;

/**
 * not the actual behavior class but just a commenality abstracation from
 * removebehavior & add behavior
 * @author jappie
 */
public abstract class BehaviorEdit extends Edit  implements IAction {
    private IBehavior	_target;
    protected BehaviorEdit(IBehavior from, IBehavior target){
	super(from);
	_target = target;
    }

    /**
     * @return the _target
     */
    protected IBehavior getTarget() {
	return _target;
    }
    @Override
    public boolean equals(Object to){
	if(!(to instanceof BehaviorEdit)){
	    return false;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	int hash = super.hashCode();
	hash = 43 * hash + (this._target != null ? this._target.hashCode() : 0);
	return hash;
    }
}
