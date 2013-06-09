/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.ActionFactory;
import World.Behaviour.Action.IAction;
import World.Behaviour.Decorator.ValidOnce;
import World.Behaviour.IBehavior;

/**
 * the only interesting it does is overwrite the behavior to be valid only once
 * @author jappie
 */
public class ActionEditFactory extends ActionFactory implements IActionEditFactory{
    @Override
    public IAction createActionAddendummer(IBehavior from, IAction target){
	return new ActionAddendummer(from, target);
    }
    @Override
    public IAction createActionRemover(IBehavior from, IAction target){
	return new ActionRemover(from, target);
    }
    
    @Override
    public IBehavior create(){
	return new ValidOnce(super.create());
    }
}
