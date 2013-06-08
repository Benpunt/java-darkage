/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock.Behaviour;

import Behaviour.Action.IAction;

/**
 *
 * @author jappie
 */
public class ActionMock extends ValidationMock implements IAction{
    public boolean onExection = true;
    public boolean executed = false;
    public void execute() {
	executed = onExection;
    }
    @Override
    public boolean equals(Object to){
	return (to instanceof ActionMock);
    }

    @Override
    public int hashCode() {
	return 1;
    }
}
