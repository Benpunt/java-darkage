/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jme3.input.controls.KeyTrigger;

/**
 *
 * @author jappie
 */
public interface IShortcutKey {

    /**
     * @return the _name
     */
    String getName();

    /**
     * @return the _trigger
     */
    KeyTrigger getTrigger();

    /**
     * executes the press.
     */
    void press();
    
}
