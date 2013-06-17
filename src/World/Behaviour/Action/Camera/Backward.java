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
public class Backward extends CameraManupilation {
    public Backward(ICameraAcces camera, IReadFloat floatAcces){
	super(camera, floatAcces);
    }
    public void execute() {
	getCamera().moveCamera(-getFloat().get(), false);
    }
}
