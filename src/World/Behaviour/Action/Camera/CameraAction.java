/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Camera;

import Engine.State.Camera.ICameraAcces;
import World.Behaviour.Action.Action;

/**
 *
 * @author jappie
 */
public abstract class CameraAction extends Action {
    private ICameraAcces _camera;
    protected CameraAction(ICameraAcces camera){
	_camera = camera;
    }

    /**
     * @return the _camera
     */
    protected ICameraAcces getCamera() {
	return _camera;
    }
}
