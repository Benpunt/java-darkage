/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import java.util.List;

/**
 *
 * listens for key presses & executes the code that is set in an implementation of shortcutkey
 * also handles the creation of the shortcutkeylistener and the binding to the input managers
 * 
 * @author jappie
 */
public class InputListener implements ActionListener, AnalogListener{
    private IInput _key;
    private InputListener(IInput key){
	_key = key;
    }
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof InputListener)){
	    return false;
	}
	return (this.hashCode() == to.hashCode());
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 23 * hash + (this._key != null ? this._key.hashCode() : 0);
	return hash;
    }

    /**
     * sets the pressed keys on true
     * @param name
     * @param isPressed
     * @param tpf 
     */
    public void onAction(String name, boolean isPressed, float tpf) {
	if(!isPressed){
	    return;
	}
	if(_key.getName().equals(name)){
	    _key.press();
	}
	
    }
    
    /**
     * binds keys to the manager.
     * for every key a new listener is created.
     * This is faster in execution but slower in startup
     * @param manager 
     */
    public static void createAndBind(InputManager manager, List<IInput> keys){
	for(IInput key : keys){
	    createAndBind(manager, key);
	}
	
    }
    
    /**
     * creates and binds a shortcutKeyListener to the input manager
     * the key listener will listen to the given key
     * @param manager
     * @param key 
     */
    public static void createAndBind(InputManager manager, IInput key){
	manager.addMapping(key.getName(), key.getTrigger());
	manager.addListener(new InputListener(key), key.getName());	
    }

    public void onAnalog(String name, float value, float tpf) {
	if(_key.getName().equals(name)){
	    _key.press(value);
	}
    }
    
}
