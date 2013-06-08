/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Scene.Shape.IShape;
import com.jme3.scene.Node;

/**
 *
 * @author jappie
 */
public interface IBody extends IForceBody {

    void add(IShape shape);

    /**
     * replaces the node with a different one.
     * automaticly detaches all the shapes and forcebodies & reataches them to the other node.
     * @param node the _node to set
     */
    void setNode(Node node);
    
}
