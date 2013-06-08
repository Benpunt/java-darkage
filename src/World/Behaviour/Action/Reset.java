/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import World.Behaviour.Condition.Resetable.IResetAble;

/**
 *
 * @author jappie
 */
public class Reset extends Action{
    private IResetAble _target;
    public Reset(IResetAble target){
	_target = target;
    }

    public void execute() {
	_target.reset();
    }
    
}
