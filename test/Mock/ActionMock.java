/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock;

import Behaviour.Action.IAction;

/**
 *
 * @author jappie
 */
public class ActionMock implements IAction{
    public boolean onExection = true;
    public boolean executed = false;
    public void Execute() {
	executed = onExection;
    }
    
}
