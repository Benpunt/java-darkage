/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State.Camera;

import Engine.State.Camera.CameraAcces.CamAction;
import World.Behaviour.IBehavior;
import World.Scene.IMoveable;
import World.Scene.ITeleportable;
import java.util.Map;

/**
 *
 * @author jappie
 */
public interface ICameraAcces extends Map<CamAction, IBehavior>, IMoveable, ITeleportable {
    
}
