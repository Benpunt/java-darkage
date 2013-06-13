/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import World.Validator;

/**
 * All actions should extend this class, (but they don't have to if they now it better)
 * @author jappie
 */
public abstract class Action extends Validator implements IAction {
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Action)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	return super.hashCode()-30000000;
    }
}
