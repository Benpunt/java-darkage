/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Scene;

import World.Scene.Solid.Body;
import World.Scene.Visual.Shape.IShape;
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
public class FixatedSolidFactory{
    private PhysicsSpace _space;
    private Node _node;
    
    public FixatedSolidFactory(PhysicsSpace space, Node rootNode){
	_space	    = space;
	_node   = rootNode;
    }

    /**
     * allows the rootnode to change
     * @param rootNode the _rootNode to set
     */
    public void setRootNode(Node rootNode) {
	this._node = rootNode;
    }

    public Body create(IShape shape) {
	World.Scene.Physical.Body physical = new World.Scene.Physical.Body(_space, 
	CollisionShapeFactory.createMeshShape(shape.getShape()));

		RigidBodyControl control = new RigidBodyControl(physical.getShape(), 0f);
	shape.getShape().addControl(control);

	World.Scene.Visual.Body visual = new World.Scene.Visual.Body(_node);
	
	return new Body(physical, visual);
    }
}
