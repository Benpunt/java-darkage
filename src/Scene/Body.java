/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import Exception.CompositionException;
import com.jme3.scene.Node;
import java.util.List;

/**
 *
 * @author jappie
 */
public abstract class Body {
    
    private Node _node;
    private List<Shape> _shapes;

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
	CompositionException.Check(node, "body", "node");
	for(Shape shape : _shapes){
	    _node.detachChild(shape.getShape());
	}
	_node = node;
	for(Shape shape : _shapes){
	    _node.attachChild(shape.getShape());
	}
    }
    
    
    
}
