/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Action;

import Behaviour.Action.IAction;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public abstract class Action {
    private IBehavior _from;
    private IAction _target;
    
    protected Action(IBehavior from, IAction target){
	_from = from;
	_target = target;
    }

    /**
     * @return the _from
     */
    public IBehavior getFrom() {
	return _from;
    }

    /**
     * @return the _target
     */
    public IAction getTarget() {
	return _target;
    }
}
