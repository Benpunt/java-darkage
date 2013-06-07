/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Action;

import Behaviour.Action.IAction;
import Behaviour.Behavior;
import Behaviour.IBehavior;

/**
 * adds an action to a behavior, the next cycle because a foreach gaurds itself
 * @see RemoveAction
 * @author jappie
 */
public class AddAction extends ActionEdit{
    
    public AddAction(IBehavior from, IAction target){
	super(from, target);
    }

    public void execute() {
	IBehavior behavior = new Behavior();
	behavior.add(new ActionAddendummer(getFrom(), getTarget()));
	getFrom().add(behavior);
    }
    
}
