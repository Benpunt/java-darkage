/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jme3.input.controls.KeyTrigger;

/**
 *
 * @author jappie
 */
public class ShortcutKey {
    private KeyTrigger _trigger;
    private String _name;
    private boolean _pressed;
    
    public ShortcutKey(String name, int key){
	_name = name;
	_trigger = new KeyTrigger(key);
    }

    /**
     * @return the _name
     */
    public String getName() {
	return _name;
    }

    /**
     * @return the _pressed
     */
    public boolean isPressed() {
	boolean value = _pressed;
	_pressed = false;
	return value;
    }

    /**
     * @param pressed the _pressed to set
     */
    public void setPressed(boolean pressed) {
	_pressed = pressed;
    }

    /**
     * @return the _trigger
     */
    public KeyTrigger getTrigger() {
	return _trigger;
    }
}
