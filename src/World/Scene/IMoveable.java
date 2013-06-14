/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import com.jme3.math.Vector3f;

/**
 * move is suposed to add difference to the current location.
 * @author jappie
 */
public interface IMoveable {
    public void move(Vector3f to);
}
