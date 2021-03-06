/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State.Camera;

import Engine.Handler.FloatHandler;
import Engine.Handler.IFloatHandler;
import Engine.State.Camera.CameraAcces.CamAction;
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
import World.Behaviour.Behavior;
import World.Behaviour.IBehavior;
import World.Factory.Factory;
import World.Factory.IFactory;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * This class initilizes the camara & its key bindings
 * It provides an api to edit the behavior of those keys at runtime.
 * 
 * the enumaration CamAction tells wich behaviors are modifiable.
 * @author jappie
 */
public class CameraAcces extends FlyByCamera implements ICameraAcces {
    private float _farSight = 1000f;
    private float _nearSight = 1f;
    private Map<CamAction, IBehavior> _behaviors;
    
    public enum CamAction {
	StrafeForward, StrafeBackward, StrafeLeft, StrafeRight,
	LookDown, LookUp, LookLeft, LookRight
    };

    public CameraAcces(Camera cam) {
	super(cam);
	_behaviors = new EnumMap<CamAction, IBehavior>(CamAction.class);
    }

    public Vector3f getLeft() {
	return cam.getLeft();
    }

    public Vector3f getUp() {
	return initialUpVec;
    }

    public boolean isYInverted() {
	return invertY;
    }

    @Override
    public void rotateCamera(float value, Vector3f axis) {
	super.rotateCamera(value, axis);
    }

    @Override
    public void zoomCamera(float value) {
	super.zoomCamera(value);
    }

    @Override
    public void riseCamera(float value) {
	super.riseCamera(value);
    }

    @Override
    public void moveCamera(float value, boolean sideways) {
	super.moveCamera(value, sideways);
    }

    public void setFarSight(float value) {
	_farSight = value;
	updateFrustrum();
    }

    public void setFarNearSight(float value) {
	_nearSight = value;
	updateFrustrum();
    }

    private void updateFrustrum() {
	cam.setFrustumPerspective(45f, (float) cam.getWidth() / cam.getHeight(), _nearSight, _farSight);
    }

    private void register(
	    InputManager inputManager,
	    IFloatHandler handler,
	    CamAction action,
	    int key) {
	BehavioredInput input =
		new BehavioredInput(
		action + "",
		_behaviors.get(action),
		key);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);
    }

    private void register(
	    InputManager inputManager,
	    IFloatHandler handler,
	    CamAction action,
	    Trigger key) {
	BehavioredInput input =
		new BehavioredInput(
		action + "",
		_behaviors.get(action),
		key);
	input.setFloatHandler(handler);
	InputListener.createAndBind(inputManager, input);
    }

    public void registerInput(InputManager inputManager) {

	IFactory<IFloatHandler> floatFactory = new Factory<IFloatHandler>(FloatHandler.class);
	IFloatHandler handler = floatFactory.create();
	_behaviors.put(CamAction.StrafeForward, new Behavior(new Forward(this, handler)));
	register(inputManager, handler, CamAction.StrafeForward, KeyInput.KEY_W);

	handler = floatFactory.create();
	_behaviors.put(CamAction.StrafeLeft, new Behavior(new StrafeLeft(this, handler)));
	register(inputManager, handler, CamAction.StrafeLeft, KeyInput.KEY_A);

	handler = floatFactory.create();
	_behaviors.put(CamAction.StrafeRight, new Behavior(new StrafeRight(this, handler)));
	register(inputManager, handler, CamAction.StrafeRight, KeyInput.KEY_D);

	handler = floatFactory.create();
	_behaviors.put(CamAction.StrafeBackward, new Behavior(new Backward(this, handler)));
	register(inputManager, handler, CamAction.StrafeBackward, KeyInput.KEY_S);

	handler = floatFactory.create();
	_behaviors.put(CamAction.LookLeft, new Behavior(new LookLeft(this, handler)));
	register(inputManager, handler, CamAction.LookLeft, new MouseAxisTrigger(MouseInput.AXIS_X, true));

	handler = floatFactory.create();
	_behaviors.put(CamAction.LookRight, new Behavior(new LookRight(this, handler)));
	register(inputManager, handler, CamAction.LookRight, new MouseAxisTrigger(MouseInput.AXIS_X, false));

	handler = floatFactory.create();
	_behaviors.put(CamAction.LookUp, new Behavior(new LookUp(this, handler)));
	register(inputManager, handler, CamAction.LookUp, new MouseAxisTrigger(MouseInput.AXIS_Y, !isYInverted()));

	handler = floatFactory.create();
	_behaviors.put(CamAction.LookDown, new Behavior(new LookDown(this, handler)));
	register(inputManager, handler, CamAction.LookDown, new MouseAxisTrigger(MouseInput.AXIS_Y, isYInverted()));
    }

    public int size() {
	return _behaviors.size();
    }

    public boolean isEmpty() {
	return _behaviors.isEmpty();
    }

    public boolean containsKey(Object key) {
	return _behaviors.containsKey(key);
    }

    public boolean containsValue(Object value) {
	return _behaviors.containsValue(value);
    }

    public IBehavior get(Object key) {
	return _behaviors.get(key);
    }

    public IBehavior put(CamAction key, IBehavior value) {
	return _behaviors.put(key, value);
    }

    public IBehavior remove(Object key) {
	return _behaviors.remove(key);
    }

    public void putAll(Map<? extends CamAction, ? extends IBehavior> m) {
	_behaviors.putAll(m);
    }

    public void clear() {
	_behaviors.clear();
    }

    public Set<CamAction> keySet() {
	return _behaviors.keySet();
    }

    public Collection<IBehavior> values() {
	return _behaviors.values();
    }

    public Set<Entry<CamAction, IBehavior>> entrySet() {
	return _behaviors.entrySet();
    }
    public void move(Vector3f to) {
	setLocation(to.addLocal(cam.getLocation()));
    }
    
    public void setLocation(Vector3f where) {
	cam.setLocation(where);
    }
    
    public Vector3f getDirection() {
	return cam.getDirection();
    }
}
