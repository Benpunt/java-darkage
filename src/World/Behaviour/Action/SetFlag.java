/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import Engine.Handler.IBoolHandler;

/**
 * Want to know if somthing has hapend? use this action to set a Iboolhandler to a value.
 * with no constructor argument defaults to true
 * @author jappie
 */
public class SetFlag extends Action {
    private static final boolean DEFAULT_VALUE = true;
    private IBoolHandler _target;
    private boolean _value;
    public SetFlag(IBoolHandler target){
	this(target, DEFAULT_VALUE);
    }
    public SetFlag(IBoolHandler target, boolean value){
	_target = target;
	_value = value;
    }

    public void execute() {
	_target.set(_value);
    }
}
