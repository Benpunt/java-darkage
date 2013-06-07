/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour;

import Behaviour.Action.IAction;
import Behaviour.Condition.ICondition;

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
