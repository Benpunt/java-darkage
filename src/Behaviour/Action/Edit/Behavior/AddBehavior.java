/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Behavior;

import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class AddBehavior extends BehaviorEdit{
    public AddBehavior(IBehavior from, IBehavior target){
	super(from, target);
    }
    public void execute() {
	getFrom().add(getTarget());
    }
    
}
