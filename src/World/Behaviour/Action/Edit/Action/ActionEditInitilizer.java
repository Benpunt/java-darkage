/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.IAction;
import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public abstract class ActionEditInitilizer extends ActionEdit{
    private IActionEditFactory  _behaviorFactory;
    protected ActionEditInitilizer(
	IBehavior from, 
	IAction target, 
	IActionEditFactory behaviorFactory
    ){
	super(from, target);
	_behaviorFactory = behaviorFactory;
    }

    /**
     * @return the _behaviorFactory
     */
    public IActionEditFactory getFactory() {
	return _behaviorFactory;
    }
}
