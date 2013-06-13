/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Camera;

import Engine.Camera.CameraAcces;
import Engine.Handler.IReadFloat;
import World.Behaviour.Action.Action;

/**
 *
 * @author jappie
 */
public class TiltRight extends CameraManupilation {
    public TiltRight(CameraAcces camera, IReadFloat floatAcces){
	super(camera, floatAcces);
    }
    public void execute() {
	getCamera().rotateCamera(-getFloat().get(), getCamera().getUp());
    }
}
