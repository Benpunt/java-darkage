/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.Behavior;
import World.Behaviour.IBehavior;
import World.Behaviour.SuperBehavior;

/**
 *
 * @author jappie
 */
public abstract class Presence extends SuperBehavior implements IPresence{
    public Presence(IBehavior behavior){
	super((behavior == null)? new Behavior() : behavior);
    }
}
