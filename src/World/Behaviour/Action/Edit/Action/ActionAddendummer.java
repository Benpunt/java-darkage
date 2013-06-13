/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.IAction;
import World.Behaviour.IBehavior;

/**
 * @see RemoveAction
 * @author jappie
 */
public class ActionAddendummer extends ActionEdit{
    
    public ActionAddendummer(IBehavior from, IAction target){
	super(from, target);
    }

    public void execute() {
	getFrom().add(getTarget());
    }
    
}
