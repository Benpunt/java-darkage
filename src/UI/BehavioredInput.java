/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Engine.Handler.IFloatHandler;
import World.Behaviour.Action.IAction;
import World.Behaviour.Behavior;
import World.Behaviour.IBehavior;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.Trigger;

/**
 * Bind behaviors to keys & other inputs...
 * @author jappie
 */
public class BehavioredInput extends Input {

    private IBehavior _analogBehavior,
	    _actionBehavior;
    private IFloatHandler _handler = null;
    private BehavioredInput(String name, Trigger trigger, IBehavior analog, IBehavior action){
	super(name, trigger);
	_analogBehavior = (analog != null)? analog : new Behavior();
	_actionBehavior = (action != null)? action : new Behavior();
    }
    public BehavioredInput(String name, IBehavior behavior, Trigger trigger) {
	this(name, trigger, behavior, null);
    }

    public BehavioredInput(String name, IBehavior behavior, int trigger) {
	this(name, new KeyTrigger(trigger), behavior, null);
    }
    
    public BehavioredInput(String name, IAction behavior, Trigger trigger) {
	this(name, trigger, new Behavior(behavior), null);
    }
    public BehavioredInput(String name, IAction behavior, int trigger) {
	this(name, new KeyTrigger(trigger), new Behavior(behavior), null);
    }
    public void press() {
	_actionBehavior.execute();

    }

    public void press(float value) {
	if (_handler != null) {
	    _handler.set(value);
	}
	_analogBehavior.execute();
    }

    public void setFloatHandler(IFloatHandler handler) {
	_handler = handler;
    }

    /**
     * @param analogBehavior the _analogBehavior to set
     */
    public void setAnalogBehavior(IBehavior analogBehavior) {
	this._analogBehavior = analogBehavior;
    }

    /**
     * @param actionBehavior the _actionBehavior to set
     */
    public void setActionBehavior(IBehavior actionBehavior) {
	this._actionBehavior = actionBehavior;
    }
}
