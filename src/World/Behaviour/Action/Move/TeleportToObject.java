/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Move;

import Engine.Log;
import com.jme3.math.Vector3f;

/**
 *
 * @author jappie
 */
public class TeleportToObject extends Teleport{
    private IReadLocation _location;
    private Vector3f _offset;
    
     public TeleportToObject(ITeleportable target, IReadLocation location){
	this(target, location, Vector3f.ZERO);
    }   
    public TeleportToObject(ITeleportable target, IReadLocation location, Vector3f offset){
	super(target, location.getLocation());
	_offset = offset;
	_location = location;
    }
    
    @Override
    public void execute() {
	Log.verbose("teleporting to object: {0}", _location);
	setCoordinate(_location.getLocation().add(_offset));
	super.execute();
    }
}
