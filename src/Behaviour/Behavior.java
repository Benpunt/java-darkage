/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour;

import Behaviour.Action.IAction;
import Behaviour.Condition.ICondition;
import java.util.Iterator;
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
public class Behavior extends Validator implements IBehavior{
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
	if(!isSufficient()){
	    return;
	}
	actionLoop(_behaviors.iterator());
	actionLoop(_actions.iterator());
    }
    
    private void actionLoop(Iterator<? extends IAction> iterator){
	while(iterator.hasNext()){
	    IAction action = iterator.next();
	    if(validAction(iterator)){
		action.execute();
	    }
	}	
    }

    public boolean isSufficient() {
	Iterator<ICondition> iterator = _conditions.iterator();
	while(iterator.hasNext()){
	    ICondition condition = iterator.next();
	    if(validAction(iterator)){
		if(!condition.isSufficient()){
		    return false;
		}
	    }
	}
	return true;
    }
    


    @Override
    public int hashCode() {
	int hash = 13;
	hash = 79 * hash + (this._actions != null ? this._actions.hashCode() : 0);
	hash = 2 * hash + (this._conditions != null ? this._conditions.hashCode() : 0);
	hash = 42 * hash + (this._behaviors != null ? this._behaviors.hashCode() : 0);
	return hash;
    }
    
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Behavior)){
	    return false;
	}
	return to.hashCode() == this.hashCode();
    }
}
