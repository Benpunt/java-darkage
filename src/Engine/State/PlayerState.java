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
    private static final int _walkSpeed = 10;
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
	ICameraAcces camera = stateManager.getState(CameraState.class).getCamera();
	
	_player = new PhysicalCharacter(
		getEngine().getSpace(), 
		new CharacterControl(new CapsuleCollisionShape(1.5f, 6f, 1), 0.1f));
	
	camera.get(CamAction.StrafeLeft).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(-_walkSpeed, 0,0), getEngine().getTpfHandler()
		)
	    )
	);
	
	camera.get(CamAction.StrafeRight).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(_walkSpeed, 0,0), getEngine().getTpfHandler()
		)
	    )
	);
	
	camera.get(CamAction.StrafeForward).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(0, 0,-_walkSpeed), getEngine().getTpfHandler()
		)
	    )
	);
	
	camera.get(CamAction.StrafeBackward).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(0, 0,_walkSpeed), getEngine().getTpfHandler()
		)
	    )
	);
	
	_player.getControll().setJumpSpeed(20);
	_player.getControll().setFallSpeed(30);
	_player.getControll().setGravity(30);
	_player.getControll().setPhysicsLocation(new Vector3f(0, 10, 100));
	
	getEngine().getBehaviors().add(new Behavior(new TeleportToObject(camera, _player)));
    }
    
    @Override
    public void update(float tpf) {
	_player.getControll().setWalkDirection(Vector3f.ZERO);
    }
}
