/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Edit.Behavior;

import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public class RemoveBehavior extends BehaviorEdit{
    
    public RemoveBehavior(IBehavior from, IBehavior target){
	super(from, target);
    }

    public void execute() {
	getFrom().remove(getTarget());
    }
    
}
