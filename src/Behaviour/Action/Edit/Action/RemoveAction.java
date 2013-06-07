/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Action;

import Behaviour.Action.IAction;
import Behaviour.Behavior;
import Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class RemoveAction extends ActionEdit implements IAction {
    public RemoveAction(IBehavior from, IAction target){
	super(from, target);
    }
    /**
     * because the stupid foreach does not alows changes to itself be made
     * from inside its loop, I have to perfom a little wizardry. I will
     * add another action that will finalize this action to the behavior loop
     * wich is not in execution. But will be executed next run.
     */
    public void execute() {
	IBehavior behavior = new Behavior();
	behavior.add(new ActionRemover(getFrom(), getTarget()));
	getFrom().add(behavior);
	
    }
}
