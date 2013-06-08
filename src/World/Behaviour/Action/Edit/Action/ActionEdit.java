/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.Edit.Edit;
import World.Behaviour.Action.IAction;
import World.IValid;
import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public abstract class ActionEdit extends Edit implements IAction{
    private IAction _target;
    protected ActionEdit(IBehavior from, IAction target){
	super(from);
	_target = target;
    }
    /**
     * @return the _target
     */
    protected IAction getTarget() {
	return _target;
    }
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof ActionEdit)){
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
	hash = 37 * hash + (this._target != null ? this._target.hashCode() : 0);
	return hash;
    }
}
