/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.IBehavior;
import com.jme3.scene.Node;

/**
 *
 * @author jappie
 */
public interface IForceBody extends IBehavior {

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
