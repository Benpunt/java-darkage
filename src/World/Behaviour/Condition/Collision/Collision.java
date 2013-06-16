/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import Engine.Handler.IReadFloat;
import Engine.Log;
import World.Behaviour.Condition.Condition;
import World.Scene.ISpatialAcces;
import World.Scene.Visual.Body;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.util.CollisionShapeFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This setup is the fastest i could think off
 * every spacial gets its own listener. The listener returns true if it colides & resets itself
 * This collison becomes true when the spatial(s) collide with anything.
 * @author jappie
 */
public class Collision extends Condition {
    private CollisionListener _listener;
    private ISpatialAcces _target;
    
    public Collision(PhysicsSpace space, ISpatialAcces target){
	_target = target;
	
	_listener = new CollisionListener(
	    CollisionShapeFactory.createBoxShape(_target.getSpatial())
	);
	space.add(_listener);
	_listener.setPhysicsLocation(_target.getSpatial().getWorldTranslation());
    }

    public boolean isSufficient() {
	_listener.setSpatial(_target.getSpatial());
	boolean colides = _listener.HasColided();
	
	Log.write(Level.FINEST, "{1} is colliding: {0}. Overlapping count: {2}", 
		colides, _target.getSpatial(), _listener.getOverlappingCount());
	return colides;
    }
}
