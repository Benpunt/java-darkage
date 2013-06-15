/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import World.Behaviour.Condition.Condition;
import World.Scene.Visual.Body;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * This setup is the fastest i could think off
 * every spacial gets its own listener. The listener returns true if it colides & resets itself
 * This collison becomes true when the spatial(s) collide with anything.
 * @author jappie
 */
public class Collision extends Condition {
    CollisionListener _listener;
    
    public Collision(PhysicsSpace space, CollisionShape shape){
	register(space, shape);
    }
    
    public Collision(PhysicsSpace space, Body target){
	register(space, CollisionShapeFactory.createMeshShape(target.getNode()));
    }
    /**
     * registers the shape to the space
     * @param space
     * @param shape 
     */
    private void register(PhysicsSpace space, CollisionShape shape){
	_listener = new CollisionListener(shape);
	space.add((PhysicsCollisionObject)_listener);	
    }

    public boolean isSufficient() {
	return _listener.HasColided();
    }
}
