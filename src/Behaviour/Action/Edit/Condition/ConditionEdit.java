/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Condition;

import Behaviour.Action.Edit.Edit;
import Behaviour.Condition.ICondition;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public abstract class ConditionEdit extends Edit {
    private ICondition _target;
    protected ConditionEdit(IBehavior from, ICondition target){
	super(from);
	_target = target;
    }

    /**
     * @return the _target
     */
    protected ICondition getTarget() {
	return _target;
    }
}
