/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.State.ScenePopulateState;
import Engine.State.Camera.CameraState;
import Engine.Handler.FloatHandler;
import Engine.Handler.IFloatHandler;
import UI.BehavioredInput;
import UI.InputListener;
import World.Behaviour.Action.Stop;
import World.Behaviour.IBehavior;
import com.jme3.app.StatsAppState;
import com.jme3.bullet.BulletAppState;
import com.jme3.input.KeyInput;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is an implementation of the vendor engine
 * makes everything tick... basicly it loads states
 * 
 * @author jappie
 */
public class Engine extends VendorEngine {
    private List<IBehavior> _behaviors;
    private IFloatHandler _tpfHandler;

    public Engine(){
	super(
		new StatsAppState(), // adds some debug texts
		new CameraState(), // creates camara & keyinput bindings
		new BulletAppState(), // loads physics
		new ScenePopulateState()
	    );
	_behaviors = new ArrayList<IBehavior>();
	_tpfHandler = new FloatHandler();
    }
    @Override
    public void init() {
	// extend vield of view, it annoys me if i can't see everything
	
	
	InputListener.createAndBind(
		inputManager,
		new BehavioredInput("Escape", new Stop(this), KeyInput.KEY_ESCAPE)
	);
	
	viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
    }

    @Override
    public void render(RenderManager rm) {
	
    }
    
    /**
     * TODO: make sence of this madness
     */
    public void update(float tpf) {
	getTpfHandler().set(tpf);
	for(IBehavior behavior : getBehaviors()){
	    behavior.execute();
	}
    }

    /**
     * @return the _behaviors
     */
    public List<IBehavior> getBehaviors() {
	return _behaviors;
    }

    /**
     * @return the _tpfHandler
     */
    public IFloatHandler getTpfHandler() {
	return _tpfHandler;
    }
}
