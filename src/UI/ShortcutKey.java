/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jme3.input.controls.KeyTrigger;

/**
 *
 * forces it implementations to have a press action
 * also forces it implementations to have a keytrigger and a name
 * so shortcutkeylistener can work with them
 * 
 * @author jappie
 */
public abstract class ShortcutKey implements IShortcutKey {
    private KeyTrigger _trigger;
    private String _name;
    
    public ShortcutKey(String name, int key){
	_name = name;
	_trigger = new KeyTrigger(key);
    }

    @Override
    public String getName() {
	return _name;
    }
    
    @Override
    public KeyTrigger getTrigger() {
	return _trigger;
    }
}
