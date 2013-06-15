/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.App;

import World.Behaviour.Action.Action;
import com.jme3.input.InputManager;

/**
 * changes the cursor visibility
 * @author jappie
 */
public class CursorVisibiltySwitch extends Action {
    private InputManager _target;
    public CursorVisibiltySwitch(InputManager target){
	_target = target;
    }
    public void execute() {
	_target.setCursorVisible(!_target.isCursorVisible());
    }
    
}
