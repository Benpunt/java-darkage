/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.App;

import World.Behaviour.Action.Action;
import com.jme3.app.Application;

/**
 *
 * @author jappie
 */
public class Stop extends Action {
    private Application _target;
    public Stop(Application target){
	_target = target;
    }

    public void execute() {
	_target.stop();
    }
}
