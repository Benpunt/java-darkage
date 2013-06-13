/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour;

import World.Behaviour.Action.IAction;
import World.Behaviour.Condition.ICondition;
import World.Validator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is a controller for all the behavior.
 * It allows clean acces to everthing that happens in the game.
 * It is prety straight forward. If all conditions are true, all sub behaviors & actions
 * get executed. No conditions, everthing gets executed
 * @author jappie
 */
public class Behavior extends Validator implements IBehavior{
    private List<IAction> _actions;
    private List<ICondition> _conditions;
    private List<IBehavior> _behaviors;
    
    public Behavior(){
	this(null, null, null);
    }
    
    public Behavior(IAction ... actions){
	this();
	_actions.addAll(Arrays.asList(actions));
    }
    
    public Behavior(ICondition ... conditions){
	this();
	_conditions.addAll(Arrays.asList(conditions));
    } 
    
    public Behavior(IBehavior ... behaviors){
	this();
	_behaviors.addAll(Arrays.asList(behaviors));
    } 
    
    public Behavior(
	List<IBehavior> behaviors, 
	List<IAction> actions, 
	List<ICondition> conditions
    ){
	_behaviors =	(behaviors != null) ? behaviors : new LinkedList<IBehavior>();
	_actions =	(actions != null)   ? actions	: new LinkedList<IAction>();
	_conditions =	(conditions != null)? conditions: new LinkedList<ICondition>();
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
	int hash = super.hashCode();
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
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }
}
