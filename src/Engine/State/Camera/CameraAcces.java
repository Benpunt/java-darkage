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
import World.Behaviour.Action.Camera.LookDown;
import World.Behaviour.Action.Camera.LookLeft;
import World.Behaviour.Action.Camera.LookRight;
import World.Behaviour.Action.Camera.LookUp;
import World.Behaviour.Action.Camera.StrafeLeft;
import World.Behaviour.Action.Camera.StrafeRight;
import World.Behaviour.IBehavior;
import World.Factory.Factory;
import World.Factory.IFactory;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import java.util.HashMap;

/**
 *
 * @author jappie
 */
public class CameraAcces extends FlyByCamera{
    private float _farSight = 1000f;
    private float _nearSight = 1f;
    private HashMap<String, IBehavior> _behaviors;
    private enum INPUTS {
	StrafeForward, StrafeBackward, StrafeLeft, StrafeRight, 
	LookDown, LookUp, LookLeft, LookRight
    };
    public CameraAcces(Camera cam){
        super(cam);
	_behaviors = new HashMap<String, IBehavior>();
    }
    public Vector3f getLeft(){
	return cam.getLeft();
    }
    public Vector3f getUp(){
	return initialUpVec;
    }
    
    public boolean isYInverted(){
	return invertY;
    }
    
    @Override
    public void rotateCamera(float value, Vector3f axis){
        super.rotateCamera(value, axis);
    }

    @Override
    public void zoomCamera(float value){
        super.zoomCamera(value);
    }

    @Override
    public void riseCamera(float value){
        super.riseCamera(value);
    }

    @Override
    public void moveCamera(float value, boolean sideways){
        super.moveCamera(value, sideways);
    }
    
    public void setFarSight(float value){
	_farSight = value;
	updateFrustrum();
    }
    public void setFarNearSight(float value){
	_nearSight = value;
	updateFrustrum();
    }
    
    private void updateFrustrum(){
	cam.setFrustumPerspective(45f, (float)cam.getWidth() / cam.getHeight(), _nearSight, _farSight);
    }
    
    public void registerInput(InputManager inputManager){
	
	IFactory<IFloatHandler> floatFactory = new Factory<IFloatHandler>(FloatHandler.class);
	IFloatHandler handler = floatFactory.create();
	BehavioredInput input = 
		new BehavioredInput(
		    "Strafe forward", 
		    new Forward(this, handler), 
		    KeyInput.KEY_W);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);


	handler = floatFactory.create();
	input = new BehavioredInput(
		    "Strafe left", 
		    new StrafeLeft(this, handler), 
		    KeyInput.KEY_A);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);


	handler = floatFactory.create();
	input = new BehavioredInput(
		    "Strafe right", 
		    new StrafeRight(this, handler), 
		    KeyInput.KEY_D);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);


	handler = floatFactory.create();
	input = new BehavioredInput(
		    "Strafe back", 
		    new Backward(this, handler), 
		    KeyInput.KEY_S);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);


	handler = floatFactory.create();
	input = new BehavioredInput(
		    "Look left", 
		    new LookLeft(this, handler), 
		    new MouseAxisTrigger(
			MouseInput.AXIS_X, 
			true)
		    );
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);


	handler = floatFactory.create();
	input = new BehavioredInput(
		    "Look right", 
		    new LookRight(this, handler), 
		    new MouseAxisTrigger(
			MouseInput.AXIS_X, 
			false)
		    );
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);


	handler = floatFactory.create();
	input = new BehavioredInput(
		    "Look up", 
		    new LookUp(this, handler), 
		    new MouseAxisTrigger(
			MouseInput.AXIS_Y, 
			!isYInverted()
		    )
		);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);


	handler = floatFactory.create();
	input = new BehavioredInput(
		    "Look down", 
		    new LookDown(this, handler), 
		    new MouseAxisTrigger(
			MouseInput.AXIS_Y, 
			this.isYInverted()
		    )
		);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);   
    }
}
