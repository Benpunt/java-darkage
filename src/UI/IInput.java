/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.Trigger;

/**
 *
 * @author jappie
 */
public interface IInput {

    /**
     * @return the _name
     */
    String getName();

    /**
     * @return the _trigger
     */
    Trigger getTrigger();

    /**
     * executes the press.
     */
    void press();
    
    /**
     * executes a press with value
     */
    void press(float value);
}
