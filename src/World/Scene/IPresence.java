/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public interface IPresence extends IMoveable, ITeleportable, IBehavior {

    /**
     * detaches the presence from a space
     */
    void detach();
    
}
