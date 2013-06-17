/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State.Camera;

import UI.BehavioredInput;
import UI.InputListener;
import World.Behaviour.Action.App.CursorVisibiltySwitch;
import World.Behaviour.Action.Camera.CameraAbleSwitch;
import World.Behaviour.Behavior;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;

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
        _flyCam = cam;
    }
    
    public CameraAcces getCamera() {
	if (_flyCam == null) {
	    _flyCam = new CameraAcces(_app.getCamera());
	    _flyCam.setMoveSpeed(200f);
	    _flyCam.setFarSight(100000f);
	}
        return _flyCam;
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        
        this._app = app;
	_inputManager = app.getInputManager();
        if (_inputManager != null) {
	    

	    getCamera().registerInput(_inputManager);
	    BehavioredInput input = new BehavioredInput(
		"mouse capture", 
		
		new Behavior(),
		KeyInput.KEY_F1
	    );
	    input.setActionBehavior(
		new Behavior(
		    new CursorVisibiltySwitch(_inputManager), // shows cursor (or not)
		    new CameraAbleSwitch(getCamera()) // disablese cam (or enable)
		));
	    InputListener.createAndBind(_inputManager, input);
	    
	    _inputManager.setCursorVisible(getCamera().isDragToRotate() || !isEnabled());
        }               
    }
            
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        
        getCamera().setEnabled(enabled);
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
        getCamera().unregisterInput();        
    }
}