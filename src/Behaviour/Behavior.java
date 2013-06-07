/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour;

import Behaviour.Action.IAction;
import Behaviour.Condition.ICondition;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is a wrapper for all the behavior.
 * It allows clean acces to everthing that happens in the game.
 * It is prety straight forward. First the behaviors get executed.
 * then this behavior gets executed, meaning:
 * If the conditions suffice the actions get executed
 * @author jappie
 */
public class Behavior implements IBehavior{
    private List<IAction> _actions;
    private List<ICondition> _conditions;
    private List<IBehavior> _behaviors;
    
    public Behavior(){
	_actions = new LinkedList<IAction>();
	_conditions = new LinkedList<ICondition>();
	_behaviors = new LinkedList<IBehavior>();
    }
    
    public void add(IAction action) {
	_actions.add(action);
    }

    public void add(ICondition condition) {
	_conditions.add(condition);
    }

    public void add(IBehavior behavior) {
	_behaviors.add(behavior);
    }

    public void remove(IAction action) {
	_actions.remove(action);
    }

    public void remove(ICondition condition) {
	_conditions.remove(condition);
    }

    public void remove(IBehavior behavior) {
	_behaviors.remove(behavior);
    }

    public void execute() {
	for(IBehavior behavior : _behaviors){
	    behavior.execute();
	}
	if(!isSufficient()){
	    return;
	}
	for(IAction action : _actions){
	    action.execute();
	}
    }

    public boolean isSufficient() {
	for(ICondition condition : _conditions){
	    if(!condition.isSufficient()){
		return false;
	    }
	}
	return true;
    }
    
}