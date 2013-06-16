/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Move;

import Engine.Handler.FloatHandler;
import Engine.Handler.IReadFloat;
import com.jme3.math.Vector3f;

/**
 * moves the target to the to value.
 * move is suposed to add difference to the current location.
 * @author jappie
 */
public class Move extends CoordinateAcces {
    private IMoveable _target;
    private IReadFloat _tpf;
    public Move(IMoveable target, Vector3f to, IReadFloat tpf){
	super(to);
	_tpf = tpf;
	_target = target;
    }

    public void execute() {
	_target.move(getCoordinate().mult(_tpf.get()));
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
