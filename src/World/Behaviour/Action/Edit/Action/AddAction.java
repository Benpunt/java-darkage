/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.IAction;
import World.Behaviour.IBehavior;

/**
 * adds an action to a behavior, the next cycle because a foreach gaurds itself
 * @see RemoveAction
 * @author jappie
 */
public class AddAction extends ActionEditInitilizer{
    
    public AddAction(IBehavior from, IAction target, IActionEditFactory behaviorFactory){
	super(from, target, behaviorFactory);
    }

    public void execute() {
	IBehavior behavior = getFactory().create();
	behavior.add(getFactory().createActionAddendummer(getFrom(), getTarget()));
	getFrom().add(behavior);
    }
    
}
