/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import java.util.ArrayList;

/**
 *
 * listens for key presses & sets the key their pressed value on true
 * so that other parts of the aplication can handle the rest.
 * 
 * TODO: make one listener handle one keypress, so the looping wont be necisary anymore.
 * TODO: make the shortcutkey abstract & its implementations handle the execution of the press
 * instead of remembering it & let some other part do the dirty work.
 * 
 * @author jappie
 */
public class ShortcutKeyListener implements ActionListener{
    private ShortcutKey _key;
    private ShortcutKeyListener(ShortcutKey key){
	_key = key;
    }

    /**
     * sets the pressed keys on true
     * @param name
     * @param isPressed
     * @param tpf 
     */
    public void onAction(String name, boolean isPressed, float tpf) {
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
    public static void createAndBind(InputManager manager, ArrayList<ShortcutKey> keys){
	for(ShortcutKey key : keys){
	    createAndBind(manager, key);
	}
	
    }
    
    /**
     * creates and binds a shortcutKeyListener to the input manager
     * the key listener will listen to the given key
     * @param manager
     * @param key 
     */
    public static void createAndBind(InputManager manager, ShortcutKey key){
	manager.addMapping(key.getName(), key.getTrigger());
	manager.addListener(new ShortcutKeyListener(key), key.getName());	
    }
    
}
