/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;

/**
 *
 * @author jappie
 */
public class CollisionListener extends GhostControl implements ICollisionListener{
    
    public CollisionListener(CollisionShape to){
	super(to);
	CharacterControl poep = new CharacterControl();
	RigidBodyControl pis = new RigidBodyControl();
    }
    
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
