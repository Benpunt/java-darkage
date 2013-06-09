/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.IAction;
import World.Behaviour.Action.IActionFactory;
import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public interface IActionEditFactory extends IActionFactory{

    IAction createActionAddendummer(IBehavior from, IAction target);
    IAction createActionRemover(IBehavior from, IAction target);
    
}
