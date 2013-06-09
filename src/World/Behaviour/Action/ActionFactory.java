/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import World.Behaviour.Action.Edit.Invalidate;
import World.Behaviour.BehaviorFactory;
import World.IValid;

/**
 *
 * @author jappie
 */
public class ActionFactory extends BehaviorFactory implements IActionFactory {
    @Override
    public IAction createInvalidate(IValid target){
	return new Invalidate(target);
    }
}
