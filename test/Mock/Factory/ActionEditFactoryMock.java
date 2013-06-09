/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock.Factory;

import World.Behaviour.Action.Edit.Action.ActionAddendummer;
import World.Behaviour.Action.Edit.Action.ActionRemover;
import World.Behaviour.Action.Edit.Action.IActionEditFactory;
import World.Behaviour.Action.Edit.Invalidate;
import World.Behaviour.Action.IAction;
import World.Behaviour.IBehavior;
import World.IValid;

/**
 *
 * @author jappie
 */
public class ActionEditFactoryMock implements IActionEditFactory{

    public IAction createInvalidate(IValid target) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public IBehavior create() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public IAction createActionAddendummer(IBehavior from, IAction target) {
	return new ActionMock();
    }

    public IAction createActionRemover(IBehavior from, IAction target) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
