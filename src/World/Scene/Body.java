/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.IBehavior;
import World.Scene.Shape.Shape;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jappie
 */
public class Body extends ForceBody{
    
    private List<Shape> _shapes;
    public Body(Node node){
	this(node, null);
	
    }
    public Body(Node node, IBehavior behavior){
	super(node, behavior);
	_shapes = new ArrayList<Shape>();
    }
        
    public void add(Shape shape){
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
	for(Shape shape : _shapes){
	    getNode().detachChild(shape.getShape());
	}
	super.setNode(node);
	for(Shape shape : _shapes){
	    getNode().attachChild(shape.getShape());
	}
    }
}
