/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Move;

import com.jme3.math.Vector3f;

/**
 * teleports the target to the given location
 * @see ITeleportable
 * @author jappie
 */
public class Teleport extends CoordinateAcces{
    private ITeleportable _target; 
    
    public Teleport(ITeleportable target, Vector3f location){
	super(location);
	_target = target;
    }

    public void execute() {
	_target.setLocation(getCoordinate());
    }
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Teleport)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	return 900 * super.hashCode() + (this._target != null ? this._target.hashCode() : 0);
    }
}
