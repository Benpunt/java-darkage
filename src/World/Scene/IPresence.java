/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.Action.Move.IMoveable;
import World.Behaviour.Action.Move.IReadLocation;
import World.Behaviour.Action.Move.ITeleportable;
import World.Behaviour.IBehavior;

/**
 *
 * @author jappie
 */
public interface IPresence extends IMoveable, ITeleportable, IBehavior, IReadLocation {

    /**
     * detaches the presence from a space
     */
    void detach();
    
}
