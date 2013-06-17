/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State;

import Engine.State.Camera.CameraAcces.CamAction;
import Engine.State.Camera.CameraState;
import Engine.State.Camera.ICameraAcces;
import World.Behaviour.Action.Move.Move;
import World.Behaviour.Action.Move.TeleportToObject;
import World.Behaviour.Behavior;
import World.Scene.IPhysicalCharacter;
import World.Scene.PhysicalCharacter;
import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;

/**
 *
 * @author jappie
 */
public class PlayerState extends EngineAccesState {
    private IPhysicalCharacter _player;
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
	ICameraAcces camera = stateManager.getState(CameraState.class).getCamera();
	
	_player = new PhysicalCharacter(
		getEngine().getSpace(), 
		new CharacterControl(new CapsuleCollisionShape(1.5f, 6f, 1), 0.0000001f));
	
	camera.get(CamAction.StrafeLeft).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(-100,0,0), getEngine().getTpfHandler()
		)
	    )
	);
	
	getEngine().getBehaviors().add(new Behavior(new TeleportToObject(camera, _player)));
    }
}
