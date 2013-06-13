/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.GhostControl;

/**
 *
 * @author jappie
 */
public class CollisionListener extends GhostControl implements ICollisionListener{
    
    private boolean _hasColided;

    public void collision(PhysicsCollisionEvent event) {
	_hasColided = true;
    }

    /**
     * listening event
     * @return the _hasColided
     */
    @Override
    public boolean HasColided() {
	boolean value = _hasColided;
	_hasColided = false;
	return value;
    }
}
