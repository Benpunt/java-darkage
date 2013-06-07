/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import Exception.CompositionException;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jappie
 */
public abstract class Body {
    
    private Node _node;
    private List<Shape> _shapes;
    
    public Body(Node node){
	checkNode(node);
	_node = node;
	_shapes = new ArrayList<Shape>();
    }

    /**
     * @return the _node
     */
    public Node getNode() {
	return _node;
    }

    /**
     * replaces the node with a different one.
     * automaticly detaches all the childeren en reataches them to the other node.
     * @param node the _node to set
     */
    public void setNode(Node node) {
	checkNode(node);
	for(Shape shape : _shapes){
	    _node.detachChild(shape.getShape());
	}
	_node = node;
	for(Shape shape : _shapes){
	    _node.attachChild(shape.getShape());
	}
    }
    
    public void add(Shape shape){
	_shapes.add(shape);
    }
    
    private void checkNode(Node node){
	CompositionException.Check(node, "body", "node");
    }
    
}
