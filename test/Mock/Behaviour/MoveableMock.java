/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock.Behaviour;

import World.Behaviour.Action.Move.IMoveable;
import com.jme3.math.Vector3f;

/**
 *
 * @author jappie
 */
public class MoveableMock implements IMoveable {
    
    public Vector3f _location = null;

    public void move(Vector3f to) {
	_location = to;
    }
    
}
