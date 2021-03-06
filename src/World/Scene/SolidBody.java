/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.Action.Move.TeleportToObject;
import World.Behaviour.Behavior;
import World.Scene.Visual.ForceBody;
import World.Scene.Visual.IBody;
import World.Scene.Visual.Shape.IShape;
import com.jme3.bullet.objects.PhysicsRigidBody;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public class SolidBody extends Presence implements ISolidBody{
    private IPhysicalBody _physical;
    private IBody  _visual;
    
    
    public SolidBody(IPhysicalBody physical, IBody visual){  
	super(new Behavior(physical, visual));
	_physical = physical;
	_visual = visual;
	add(new Behavior(
		new TeleportToObject(_visual, this)
	    )
	);
    }  

    @Override
    public void detach() {
	_physical.detach();
	_visual.detach();
    }

    public void setLocation(Vector3f where) {
	_physical.setLocation(where);
    }

    public void move(Vector3f to) {
	_physical.move(to);
    }

    public PhysicsRigidBody getPhysicsBody() {
	return _physical.getPhysicsBody();
    }

    public void setPhysicsBody(PhysicsRigidBody shape) {
	_physical.setPhysicsBody(shape);
    }

    public void add(IShape shape) {
	_visual.add(shape);
    }

    public void setNode(Node node) {
	_visual.setNode(node);
    }

    public void add(ForceBody body) {
	_visual.add(body);
    }

    public Node getNode() {
	return _visual.getNode();
    }

    public Spatial getSpatial() {
	return _visual.getSpatial();
    }

    public Vector3f getLocation() {
	
	// physical has only one world coordinate system
	// whereas the visual can have coordinate systems inside coordinate systems.
	return _physical.getLocation(); 
    }
}
