/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State.Camera;

import Engine.State.Camera.CameraAcces.CamAction;
import World.Behaviour.IBehavior;
import World.Behaviour.Action.Move.IMoveable;
import World.Behaviour.Action.Move.ITeleportable;
import java.util.Map;

/**
 *
 * @author jappie
 */
public interface ICameraAcces extends Map<CamAction, IBehavior>, IMoveable, ITeleportable {
    
}
