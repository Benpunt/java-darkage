/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.IAction;
import World.Behaviour.Behavior;
import World.Behaviour.Decorator.ValidOnce;
import World.Behaviour.IBehavior;

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
	IBehavior behavior = new ValidOnce(new Behavior());
	behavior.add(new ActionAddendummer(getFrom(), getTarget()));
	getFrom().add(behavior);
    }
    
}
