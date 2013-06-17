/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Scene;

import World.Scene.PhysicalBody;
import World.Scene.SolidBody;
import World.Scene.Visual.IBody;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.scene.Node;

/**
 * Problem with solids is that they induce a lot of name clashing
 * Perhaps a renaming session wil do it good. If the structure remains the same
 * I probably wil do just that
 * @author jappie
 */
public class SolidFactory{
    private PhysicsSpace _space;
    
    public SolidFactory(PhysicsSpace space){
	_space	    = space;
    }
    
    public SolidBody createFromVisual(IBody visual){
	return createFromVisual(visual, 0);
    }
    
    public SolidBody createFromVisual(IBody visual, float weight){
	RigidBodyControl controller = new RigidBodyControl(
	    CollisionShapeFactory.createMeshShape(visual.getNode()), weight
	);
	_space.add(controller);
	
	controller.setPhysicsLocation(visual.getLocation());
	
	return new SolidBody(new PhysicalBody(_space, controller), visual);
    }
}
