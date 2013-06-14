/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import Exception.CompositionException;
import World.Behaviour.IBehavior;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.objects.PhysicsRigidBody;
import com.jme3.math.Vector3f;

/**
 *
 * @author jappie
 */
public class PhysicalBody extends Presence implements IPhysicalBody{
    private PhysicsRigidBody _physicsBody;
    private PhysicsSpace _space;
    public PhysicalBody(PhysicsSpace space, PhysicsRigidBody shape){
	this(space, shape, null);
    }
    public PhysicalBody(PhysicsSpace space, PhysicsRigidBody shape, IBehavior behavior){
	super(behavior);
	check(shape);
	_physicsBody = shape;
	_space = space;
	_space.add(_physicsBody);
    }

    /**
     * @return the _shape
     */
    @Override
    public PhysicsRigidBody getPhysicsBody() {
	return _physicsBody;
    }

    /**
     * @param shape the _shape to set
     */
    @Override
    public void setPhysicsBody(PhysicsRigidBody shape) {
	check(shape);
	_space.remove(_physicsBody);
	_physicsBody = shape;
	_space.add(_physicsBody);
    }
    
    public void detach(){
	_space.remove(_physicsBody);
    }
    
    private void check(PhysicsRigidBody shape){
	CompositionException.Check(shape, "Physical.body", "PhysicsRigidBody");
    }

    public void setLocation(Vector3f to) {
	_physicsBody.setPhysicsLocation(to);
    }

    public void move(Vector3f to) {
	_physicsBody.setLinearVelocity(to);
    }
}
