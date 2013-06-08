/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import Exception.CompositionException;
import World.Behaviour.Action.IAction;
import World.Behaviour.Behavior;
import World.Behaviour.Condition.ICondition;
import World.Behaviour.IBehavior;
import World.Validator;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jappie
 */
public abstract class ForceBody extends Validator implements IBehavior {
    
    private Node _node;
    private List<ForceBody> _bodies;
    private IBehavior _behavior;
    
    protected ForceBody(Node node, IBehavior behavior){
	if(behavior == null){
	    behavior = new Behavior();
	}
	checkNode(node);
	_node = node;
	_bodies = new ArrayList<ForceBody>();
	_behavior = behavior;	
    }
    
    protected ForceBody(Node node){
	this(node, null);
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
	_behavior.add(action);
    }

    public void add(ICondition condition) {
	_behavior.add(condition);
    }

    public void add(IBehavior behavior) {
	_behavior.add(behavior);
    }

    public void remove(IAction action) {
	_behavior.add(action);
    }

    public void remove(ICondition condition) {
	_behavior.add(condition);
    }

    public void remove(IBehavior behavior) {
	_behavior.add(behavior);
    }

    public void execute() {
	_behavior.execute();
    }

    public boolean isSufficient() {
	return _behavior.isSufficient();
    }
    
}
