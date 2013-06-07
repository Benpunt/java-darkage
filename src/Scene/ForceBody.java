/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import Scene.Shapes.Shape;
import Exception.CompositionException;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jappie
 */
public abstract class ForceBody {
    
    private Node _node;
    private List<ForceBody> _bodies;
    
    protected ForceBody(Node node){
	checkNode(node);
	_node = node;
	_bodies = new ArrayList<ForceBody>();
    }

    /**
     * @return the _node
     */
    public Node getNode() {
	return _node;
    }

    /**
     * replaces the node with a different one.
     * detaches and reataches all the forcebodies
     * @param node the _node to set
     */
    public void setNode(Node node) {
	checkNode(node);
	for(ForceBody body : _bodies){
	    _node.detachChild(body.getNode());
	}
	_node = node;
	for(ForceBody body : _bodies){
	    _node.attachChild(body.getNode());
	}
    }

    
    public void add(ForceBody body){
	_bodies.add(body);
	_node.attachChild(body.getNode());
    }
    
    private void checkNode(Node node){
	CompositionException.Check(node, "body", "node");
    }
    
}
