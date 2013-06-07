/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit.Action;

import Behaviour.Action.IAction;
import Behaviour.IBehavior;

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
