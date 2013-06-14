/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Move;

import World.Behaviour.Action.Action;
import com.jme3.math.Vector3f;

/**
 * defines acces to a vector for other actions
 * @author jappie
 */
public abstract class CoordinateAcces extends Action{
    private Vector3f _coordinate;
    public CoordinateAcces(Vector3f coordinate){
	_coordinate = coordinate;
    }

    /**
     * @return the _coordinate
     */
    protected Vector3f getCoordinate() {
	return _coordinate;
    }
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof CoordinateAcces)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	return 67 * 7 *super.hashCode() 
		- (this._coordinate != null ? this._coordinate.hashCode() : 0);
    }
}
