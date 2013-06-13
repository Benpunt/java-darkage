/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.PhysicsControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author jappie
 */
public interface ICollisionListener extends PhysicsControl, Control, PhysicsCollisionListener{

    /**
     * listening event
     * @return the _hasColided
     */
    boolean HasColided();
    
}
