/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.Action.IAction;
import World.Behaviour.Condition.ICondition;
import World.Behaviour.IBehavior;
import Exception.CompositionException;
import World.Validator;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jappie
 */
public abstract class ForceBody extends Validator implements IBehavior {
    
    private Node _node;
    private List<ForceBody> _bodies;
    private IBehavior _behavior;
    
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

    public void add(IAction action) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void add(ICondition condition) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void add(IBehavior behavior) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(IAction action) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(ICondition condition) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(IBehavior behavior) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void execute() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isSufficient() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
