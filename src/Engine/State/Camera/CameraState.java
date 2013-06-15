/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State.Camera;

import Engine.Handler.FloatHandler;
import Engine.Handler.IFloatHandler;
import UI.BehavioredInput;
import UI.InputListener;
import World.Behaviour.Action.Camera.Backward;
import World.Behaviour.Action.Camera.Forward;
import World.Behaviour.Action.Camera.StrafeLeft;
import World.Behaviour.Action.Camera.StrafeRight;
import World.Behaviour.Action.Camera.TiltDown;
import World.Behaviour.Action.Camera.TiltLeft;
import World.Behaviour.Action.Camera.TiltRight;
import World.Behaviour.Action.Camera.TiltUp;
import World.Factory.Factory;
import World.Factory.IFactory;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.MouseAxisTrigger;

/**
 * replaces thedefault flycamstate so I could change keybindings
 * @author jappie
 */
public class CameraState extends AbstractAppState {

    private Application _app;
    private CameraAcces _flyCam;
    private InputManager _inputManager;
    public CameraState() {
    }    

    /**
     *  This is called by SimpleApplication during initialize().
     */
    void setCamera( CameraAcces cam ) {
        this._flyCam = cam;
    }
    
    public CameraAcces getCamera() {
        return _flyCam;
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        
        this._app = app;
	_inputManager = app.getInputManager();
        if (_inputManager != null) {
	    
            if (_flyCam == null) {
                _flyCam = new CameraAcces(app.getCamera());
		_flyCam.setMoveSpeed(200f);
		_flyCam.setFarSight(100000f);
	    }
	    IFactory<IFloatHandler> floatFactory = new Factory<IFloatHandler>(FloatHandler.class);
	    IFloatHandler handler = floatFactory.create();
	    BehavioredInput input = 
		    new BehavioredInput(
			"Strafe forward", 
			new Forward(_flyCam, handler), 
			KeyInput.KEY_W);
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);
	    
	    
	    handler = floatFactory.create();
	    input = new BehavioredInput(
			"Strafe left", 
			new StrafeLeft(_flyCam, handler), 
			KeyInput.KEY_A);
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);
	    
	    
	    handler = floatFactory.create();
	    input = new BehavioredInput(
			"Strafe right", 
			new StrafeRight(_flyCam, handler), 
			KeyInput.KEY_D);
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);
	    
	    
	    handler = floatFactory.create();
	    input = new BehavioredInput(
			"Strafe back", 
			new Backward(_flyCam, handler), 
			KeyInput.KEY_S);
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);
	    
	    
	    handler = floatFactory.create();
	    input = new BehavioredInput(
			"tilt left", 
			new TiltLeft(_flyCam, handler), 
			new MouseAxisTrigger(
			    MouseInput.AXIS_X, 
			    true)
			);
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);

	    
	    handler = floatFactory.create();
	    input = new BehavioredInput(
			"tilt right", 
			new TiltRight(_flyCam, handler), 
			new MouseAxisTrigger(
			    MouseInput.AXIS_X, 
			    false)
			);
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);

	    
	    handler = floatFactory.create();
	    input = new BehavioredInput(
			"tilt up", 
			new TiltUp(_flyCam, handler), 
			new MouseAxisTrigger(
			    MouseInput.AXIS_Y, 
			    !_flyCam.isYInverted()
			)
		    );
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);
	    
	    
	    handler = floatFactory.create();
	    input = new BehavioredInput(
			"tilt down", 
			new TiltDown(_flyCam, handler), 
			new MouseAxisTrigger(
			    MouseInput.AXIS_Y, 
			    _flyCam.isYInverted()
			)
		    );
	    input.setFloatHandler(handler);
	    InputListener.createAndBind(_inputManager, input);
	    
	    _inputManager.setCursorVisible(_flyCam.isDragToRotate() || !isEnabled());
        }               
    }
            
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        
        _flyCam.setEnabled(enabled);
    }
    
    @Override
    public void cleanup() {
        super.cleanup();

        _flyCam.unregisterInput();        
    }
    
    @Override
    public void update(float tpf) {
	if(_inputManager != null){
	    _inputManager.setCursorVisible(_flyCam.isDragToRotate() || !isEnabled());
	}
    }
}