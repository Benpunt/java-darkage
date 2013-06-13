/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import com.jme3.scene.control.Control;

/**
 *
 * @author jappie
 */
public interface ICollisionListener extends Control{

    /**
     * listening event
     * @return the _hasColided
     */
    boolean HasColided();
    
}
