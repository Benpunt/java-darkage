/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import World.Behaviour.IBehavior;
import World.Factory.IFactory;
import World.IValid;

/**
 *
 * @author jappie
 */
public interface IActionFactory extends IFactory<IBehavior> {

    IAction createInvalidate(IValid target);
    
}
