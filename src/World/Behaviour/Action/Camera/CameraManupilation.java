/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Camera;

import Engine.Handler.IReadFloat;
import Engine.State.Camera.ICameraAcces;

/**
 *
 * @author jappie
 */
public abstract class CameraManupilation extends CameraAction{
    private IReadFloat _float;
    protected CameraManupilation(ICameraAcces camera, IReadFloat floatAcces){
	super(camera);
	_float = floatAcces;
    }

    /**
     * @return the _float
     */
    protected IReadFloat getFloat() {
	return _float;
    }
}
