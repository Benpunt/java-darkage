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
public abstract class Presence extends SuperBehavior{
    public Presence(IBehavior behavior){
	super((behavior == null)? new Behavior() : behavior);
    }
    
    /**
     * detaches the presence from a space
     */
    public abstract void detach();
}
