/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Visual;

import World.Behaviour.IBehavior;
import World.Scene.Visual.Shape.IShape;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jappie
 */
public class Body extends ForceBody implements IBody{
    
    private List<IShape> _shapes;
    public Body(Node node){
	this(node, null);
    }
    
    public Body(Node node, IBehavior behavior){
	super(node, behavior);
	_shapes = new ArrayList<IShape>();
    }
        
    @Override
    public void add(IShape shape){
	_shapes.add(shape);
	getNode().attachChild(shape.getShape());
    }
    
    /**
     * replaces the node with a different one.
     * automaticly detaches all the shapes and forcebodies & reataches them to the other node.
     * @param node the _node to set
     */
    @Override
    public void setNode(Node node) {
	detach();
	super.setNode(node);
	for(IShape shape : _shapes){
	    getNode().attachChild(shape.getShape());
	}
    }

    @Override
    public void detach() {
	super.detach();
	for(IShape shape : _shapes){
	    getNode().detachChild(shape.getShape());
	}
    }

    public void setLocation(Vector3f where) {
	getNode().center();
	getNode().move(where);
    }

    public void move(Vector3f to) {
	getNode().move(to);
    }

    public Spatial getSpatial() {
	return getNode();
    }

    public Vector3f getLocation() {
	return getNode().getWorldTranslation();
    }
}
