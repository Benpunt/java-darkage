/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Visual;

import Exception.CompositionException;
import World.Behaviour.IBehavior;
import World.Scene.Presence;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jappie
 */
public abstract class ForceBody extends Presence implements IForceBody{
    
    private Node _node;
    private List<IForceBody> _bodies;
    
    protected ForceBody(Node node, IBehavior behavior){
	super(null);
	checkNode(node);
	_node = node;
	_bodies = new ArrayList<IForceBody>();
    }
    
    protected ForceBody(Node node){
	this(node, null);
    }

    /**
     * @return the _node
     */
    @Override
    public Node getNode() {
	return _node;
    }

    /**
     * replaces the node with a different one.
     * detaches and reataches all the forcebodies
     * @param node the _node to set
     */
    @Override
    public void setNode(Node node) {
	checkNode(node);
	detach();
	_node = node;
	for(IForceBody body : _bodies){
	    _node.attachChild(body.getNode());
	}
    }

    
    @Override
    public void add(ForceBody body){
	_bodies.add(body);
	_node.attachChild(body.getNode());
    }
    
    private void checkNode(Node node){
	CompositionException.Check(node, "body", "node");
    }
    
    @Override
    public void detach(){
	for(IForceBody body : _bodies){
	    _node.detachChild(body.getNode());
	}	
    }
}
