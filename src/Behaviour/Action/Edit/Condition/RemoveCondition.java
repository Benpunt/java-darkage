/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Condition;

import Behaviour.Condition.ICondition;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class RemoveCondition extends ConditionEdit{
    
    public RemoveCondition(IBehavior from, ICondition target){
	super(from, target);
    }

    public void execute() {
	getFrom().remove(getTarget());
    }
    
}
