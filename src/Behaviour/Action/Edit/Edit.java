/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit;

import Behaviour.IBehavior;
import Behaviour.Validator;

/**
 *
 * @author jappie
 */
public abstract class Edit extends Validator {
    private IBehavior _from;
    
    protected Edit (IBehavior from){
	_from = from;
    }
    
    /**
     * @return the _from
     */
    protected IBehavior getFrom() {
	return _from;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 37 * hash + (this._from != null ? this._from.hashCode() : 0);
	return hash;
    }
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Edit)){
	    return false;
	}
	return to.hashCode() == this.hashCode();
    }
}
