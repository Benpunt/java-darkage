/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Behavior;

import Behaviour.IBehavior;

/**
 * not the actual behavior class but just a commenality abstracation from
 * removebehavior & add behavior
 * @author jappie
 */
public abstract class Behavior {
    private IBehavior	_target,
			_from;
    protected Behavior(IBehavior from, IBehavior target){
	_from = from;
	_target = target;
    }

    /**
     * @return the _target
     */
    protected IBehavior getTarget() {
	return _target;
    }

    /**
     * @return the _from
     */
    protected IBehavior getFrom() {
	return _from;
    }
}
