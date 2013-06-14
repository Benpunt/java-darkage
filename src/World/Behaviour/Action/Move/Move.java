/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Move;

import World.Scene.IMoveable;
import com.jme3.math.Vector3f;

/**
 * moves the target to the to value.
 * @author jappie
 */
public class Move extends CoordinateAcces {
    private IMoveable _target;
    public Move(IMoveable target, Vector3f to){
	super(to);
	_target = target;
    }

    public void execute() {
	_target.move(getCoordinate());
    }
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Move)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	return 17 * super.hashCode() + (this._target != null ? this._target.hashCode() : 0);
    }
}
