/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Behavior;

import Behaviour.Action.Edit.Edit;
import Behaviour.IBehavior;

/**
 * not the actual behavior class but just a commenality abstracation from
 * removebehavior & add behavior
 * @author jappie
 */
public abstract class BehaviorEdit extends Edit {
    private IBehavior	_target,
			_from;
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
}
