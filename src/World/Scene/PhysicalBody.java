/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import Exception.CompositionException;
import World.Behaviour.IBehavior;
import World.Scene.Presence;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.CollisionShape;

/**
 *
 * @author jappie
 */
public class PhysicalBody extends Presence{
    private CollisionShape _shape;
    private PhysicsSpace _space;
    public PhysicalBody(PhysicsSpace space, CollisionShape shape){
	this(space, shape, null);
    }
    public PhysicalBody(PhysicsSpace space, CollisionShape shape, IBehavior behavior){
	super(behavior);
	check(shape);
	_shape = shape;
	_space = space;
	_space.add(_shape);
    }

    /**
     * @return the _shape
     */
    public CollisionShape getShape() {
	return _shape;
    }

    /**
     * @param shape the _shape to set
     */
    public void setShape(CollisionShape shape) {
	check(shape);
	_space.remove(_shape);
	_shape = shape;
	_space.add(_shape);
    }
    
    public void detach(){
	_space.remove(_shape);
    }
    
    private void check(CollisionShape shape){
	CompositionException.Check(shape, "Physical.body", "collisionShape");
    }
}
