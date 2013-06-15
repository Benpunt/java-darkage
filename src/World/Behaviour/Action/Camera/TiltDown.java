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
public class TiltDown extends CameraManupilation {
    public TiltDown(CameraAcces camera, IReadFloat floatAcces){
	super(camera, floatAcces);
    }
    public void execute() {
	getCamera().rotateCamera(-getFloat().get(), getCamera().getLeft());
    }
}
