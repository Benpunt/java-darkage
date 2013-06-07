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
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof ShortcutKey)){
	    return false;
	}
	return this.hashCode() == to.hashCode();
	
    }

    @Override
    public int hashCode() {
	int hash = 2;
	hash = 17 * hash + (this._trigger != null ? this._trigger.hashCode() : 0);
	hash += 10 * hash + (this._name != null ? this._name.hashCode() : 0);
	return hash;
    }
}
