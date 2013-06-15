/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Camera;

import Engine.State.Camera.CameraAcces;
import World.Behaviour.Action.Action;

/**
 *
 * @author jappie
 */
public abstract class CameraAction extends Action {
    private CameraAcces _camera;
    protected CameraAction(CameraAcces camera){
	_camera = camera;
    }

    /**
     * @return the _camera
     */
    protected CameraAcces getCamera() {
	return _camera;
    }
}
