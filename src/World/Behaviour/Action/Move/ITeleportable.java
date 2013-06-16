/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Move;

import com.jme3.math.Vector3f;

/**
 * teleport is suposed to move somthing to the absolute where location.
 * @author jappie
 */
public interface ITeleportable {
    public void setLocation(Vector3f where);
}
