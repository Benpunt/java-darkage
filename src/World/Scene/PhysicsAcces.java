/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.IBehavior;
import com.jme3.bullet.PhysicsSpace;

/**
 * physics space was used in physicalbody & physical character
 * @author jappie
 */
public abstract class PhysicsAcces extends Presence{
    private PhysicsSpace _space;
    
    public PhysicsAcces(PhysicsSpace space, IBehavior behavior){
	super(behavior);
	_space = space;
    }

    /**
     * @return the _space
     */
    protected PhysicsSpace getSpace() {
	return _space;
    }
}
