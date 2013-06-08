/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Condition;

import World.Behaviour.Condition.ICondition;
import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class AddCondition extends ConditionEdit {
    public AddCondition(IBehavior from, ICondition target){
	super(from, target);
    }
    public void execute() {
	getFrom().add(getTarget());
    }
    
}
