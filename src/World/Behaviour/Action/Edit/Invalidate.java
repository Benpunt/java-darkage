/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit;

import World.Behaviour.Action.Action;
import World.Behaviour.Action.IAction;
import World.IValid;
import World.Validator;

/**
 * Use this action to remove actions from their own loops.
 * For example an action from the action execute method.
 * 
 * & yes an object of this action can remove itself. well the behavior does.
 * 
 * An importet thing to note is that this code expects itself to be synchronus. 
 * 
 * @see Behaviour.Behavior
 * @author jappie
 */
public class Invalidate extends Action implements IAction{
    private IValid _target;
    public Invalidate(IValid target){
	_target = target;
    }

    public void execute() {
	_target.invalidate();
    }
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Invalidate)){
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
	hash = 97 * hash + (this._target != null ? _target.hashCode() : 0);
	return hash;
    }
}
