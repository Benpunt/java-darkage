/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Behavior;

import Behaviour.Action.IAction;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class RemoveBehavior extends BehaviorEdit implements IAction{
    
    public RemoveBehavior(IBehavior from, IBehavior target){
	super(from, target);
    }

    public void execute() {
	getFrom().remove(getTarget());
    }
    
}
