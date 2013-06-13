/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Camera;

import Engine.Camera.CameraAcces;
import Engine.Handler.IReadFloat;

/**
 *
 * @author jappie
 */
public class Forward extends CameraManupilation {
    public Forward(CameraAcces camera, IReadFloat floatAcces){
	super(camera, floatAcces);
    }
    public void execute() {
	getCamera().moveCamera(getFloat().get(), false);
    }
}
