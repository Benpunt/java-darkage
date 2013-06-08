/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour;

import World.Behaviour.Action.IAction;
import World.Behaviour.Condition.ICondition;

/**
 *
 * @author jappie
 */
public interface IBehavior extends IAction, ICondition {
    void add(IAction action);
    void add(ICondition condition);
    void add(IBehavior behavior);
    void remove(IAction action);
    void remove(ICondition condition);
    void remove(IBehavior behavior);
    
}
