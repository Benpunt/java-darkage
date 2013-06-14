/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Visual;

import World.Behaviour.IBehavior;
import World.Scene.IPresence;
import com.jme3.scene.Node;

/**
 *
 * @author jappie
 */
public interface IForceBody extends IPresence {

    void add(ForceBody body);

    /**
     * @return the _node
     */
    Node getNode();

    /**
     * replaces the node with a different one.
     * detaches and reataches all the forcebodies
     * @param node the _node to set
     */
    void setNode(Node node);
    
}
