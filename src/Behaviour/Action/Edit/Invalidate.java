/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour.Action.Edit;

import Behaviour.Action.IAction;
import Behaviour.IValid;
import Behaviour.Validator;

/**
 * Use this action to remove actions from their own loops.
 * For example an action from the action execute method.
 * 
 * & yes an object of this action can remove itself. well the behavior does.
 * @see Behaviour.Behavior
 * @author jappie
 */
public class Invalidate extends Validator implements IAction{
    private IValid _target;
    public Invalidate(IValid target){
	_target = target;
    }

    public void execute() {
	_target.invalidate();
    }
}
