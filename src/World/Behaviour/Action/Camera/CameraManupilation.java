/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Camera;

import Engine.State.Camera.CameraAcces;
import Engine.Handler.IReadFloat;
import World.Behaviour.Action.Action;

/**
 *
 * @author jappie
 */
public abstract class CameraManupilation extends Action{
    private CameraAcces _camera;
    private IReadFloat _float;
    public CameraManupilation(CameraAcces camera, IReadFloat floatAcces){
	_camera = camera;
	_float = floatAcces;
    }

    /**
     * @return the _camera
     */
    public CameraAcces getCamera() {
	return _camera;
    }

    /**
     * @return the _float
     */
    public IReadFloat getFloat() {
	return _float;
    }
}
