/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Action;

import Behaviour.Action.Edit.Edit;
import Behaviour.Action.IAction;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public abstract class ActionEdit extends Edit{
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
}
