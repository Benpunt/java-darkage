/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit;

import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public abstract class Edit {
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
}
