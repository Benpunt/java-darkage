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
public class LookRight extends CameraManupilation {
    public LookRight(ICameraAcces camera, IReadFloat floatAcces){
	super(camera, floatAcces);
    }
    public void execute() {
	getCamera().rotateCamera(-getFloat().get(), getCamera().getUp());
    }
}
