/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.GhostControl;

/**
 *
 * @author jappie
 */
public class CollisionListener extends GhostControl implements ICollisionListener{
    
    public CollisionListener(CollisionShape to){
	super(to);
    }
    
    private boolean _hasColided;

    /**
     * does not work with ghostcontroll at least.
     * But i get an error when i do not implement it. So I kept the original intenden functionality
     * @param event 
     */
    public void collision(PhysicsCollisionEvent event) {
	_hasColided = true;
    }

    /**
     * listening event
     * @return the _hasColided
     */
    @Override
    public boolean HasColided() {
	boolean value = (getOverlappingCount() > 0) || _hasColided;
	_hasColided = false;
	return value;
    }
}
