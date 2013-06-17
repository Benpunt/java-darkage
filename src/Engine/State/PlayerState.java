/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State;

import Engine.Handler.BoolHandler;
import Engine.Handler.IBoolHandler;
import Engine.State.Camera.CameraAcces.CamAction;
import Engine.State.Camera.CameraState;
import Engine.State.Camera.ICameraAcces;
import World.Behaviour.Action.Move.Move;
import World.Behaviour.Action.Move.TeleportToObject;
import World.Behaviour.Action.SetFlag;
import World.Behaviour.Behavior;
import World.Scene.IPhysicalCharacter;
import World.Scene.PhysicalCharacter;
import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;

/**
 * this class completly kills any attempts of the camerastate to create a floating.
 * the camera gets continuslie transported to the player.
 * @author jappie
 */
public class PlayerState extends EngineAccesState {
    private IPhysicalCharacter _player;
    private static final int _walkSpeed = 10;
    private IBoolHandler _moveKeyPressed = new BoolHandler(false);
    private ICameraAcces _camera;
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
	 _camera = stateManager.getState(CameraState.class).getCamera();
	
	_player = new PhysicalCharacter(
		getEngine().getSpace(), 
		new CharacterControl(new CapsuleCollisionShape(1.5f, 6f, 1), 0.1f));
	
	_camera.get(CamAction.StrafeLeft).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(-_walkSpeed, 0,0), getEngine().getTpfHandler()
		),
		createFlag()
	    )
	);
	
	_camera.get(CamAction.StrafeRight).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(_walkSpeed, 0,0), getEngine().getTpfHandler()
		),
		createFlag()
	    )
	);
	
	_camera.get(CamAction.StrafeForward).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(0, 0,-_walkSpeed), getEngine().getTpfHandler()
		),
		createFlag()
	    )
	);
	
	_camera.get(CamAction.StrafeBackward).add(
	    new Behavior(
		new Move(
		    _player, new Vector3f(0, 0,_walkSpeed), getEngine().getTpfHandler()
		),
		createFlag()
	    )
	);
	
	_player.getControll().setJumpSpeed(20);
	_player.getControll().setFallSpeed(30);
	_player.getControll().setGravity(30);
	_player.getControll().setPhysicsLocation(new Vector3f(0, 10, 100));
    }
    
    @Override
    public void update(float tpf) {
	if(_moveKeyPressed.is()){
	    _moveKeyPressed.set(false);
	}else{
	    _player.getControll().setWalkDirection(Vector3f.ZERO);
	}
	_camera.setLocation(_player.getLocation()); // overwrites the cameras attempts to escape
    }
    
    private SetFlag createFlag(){
	return new SetFlag(_moveKeyPressed, true);
    }
}
