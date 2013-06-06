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
    private ArrayList<ShortcutKey> _keys;
    public ShortcutKeyListener(ArrayList<ShortcutKey> keys){
	_keys = keys;
    }

    /**
     * sets the pressed keys on true
     * @param name
     * @param isPressed
     * @param tpf 
     */
    public void onAction(String name, boolean isPressed, float tpf) {
	for(ShortcutKey key : _keys){
	    if(key.getName().equals(name)){
		key.setPressed(isPressed);
	    }
	}
    }
    
    /**
     * binds the keys in this listener to the manager.
     * Also starts listening
     * @param manager 
     */
    public void bindKeys(InputManager manager){
	
	for(ShortcutKey key : _keys){
	    manager.addMapping(key.getName(), key.getTrigger());
	    manager.addListener(this,key.getName());
	}
	
    }
    
}
