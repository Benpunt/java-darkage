/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.IAction;
import World.Behaviour.IBehavior;

/**
 * Peforms the final stage of the action remove proces 
 * @see RemoveAction
 * @author jappie
 */
public class ActionRemover extends ActionEdit{

    public ActionRemover(IBehavior from, IAction target){
	super(from, target);
    }
    public void execute() {
	getFrom().remove(getTarget());
    }
    @Override
    public boolean equals(Object to){
	if(!(to instanceof ActionRemover)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	return super.hashCode()+12;
    }
}
