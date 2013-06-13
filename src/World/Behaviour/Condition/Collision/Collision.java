/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Collision;

import World.Behaviour.Condition.Condition;
import com.jme3.scene.Spatial;

/**
 * This setup is the fastest i could think off
 * every spacial gets its own listener. The listener returns true if it colides & resets itself
 * This collison becomes true when the spatial(s) collide with anything.
 * @author jappie
 */
public class Collision extends Condition {
    ICollisionListener _listener;
    
    public Collision(Spatial ... targets){
	_listener = new CollisionListener();
	
	for(Spatial shape : targets){
	    shape.addControl(_listener);
	}
    }

    public boolean isSufficient() {
	return _listener.HasColided();
    }
}