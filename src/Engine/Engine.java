/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.Handler.FloatHandler;
import Engine.Handler.IFloatHandler;
import UI.BehavioredInput;
import UI.InputListener;
import World.Behaviour.Action.Stop;
import World.Behaviour.Behavior;
import World.Behaviour.Condition.Collision.Collision;
import World.Behaviour.IBehavior;
import World.Factory.Scene.BodyFactory;
import World.Factory.Scene.ShapeFactory;
import World.Scene.Visual.Body;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.input.KeyInput;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is an implementation of the vendor engine
 * It handles all my addendums to the world and shows stuff
 * 
 * @author jappie
 */
public class Engine extends VendorEngine {
    private BodyFactory _bodyFactory;
    private List<IBehavior> _behaviors;
    private IFloatHandler _tpfHandler;
    private Body _sillyCubes;
    @Override
    public void init() {
	// extend vield of view, it annoys me if i can't see everything
	
	
	InputListener.createAndBind(
		inputManager,
		new BehavioredInput("Escape", new Stop(this), KeyInput.KEY_ESCAPE)
	);
	
	
	_tpfHandler = new FloatHandler();
	
	viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
	
	PhysicsSpace space = stateManager.getState(BulletAppState.class).getPhysicsSpace();
	
	ShapeFactory shapeFactory = new ShapeFactory(assetManager);
	_bodyFactory = new BodyFactory(getRootNode(), shapeFactory);
	_behaviors = new ArrayList<IBehavior>();
	
	Body targetCubes = _bodyFactory.createCubes();
	
	
	_sillyCubes = _bodyFactory.createCubes();
	
	
	_sillyCubes.getNode().move(0f, 100f, 0f);
	

	 
	/** Must add a light to make the lit object visible! */
	DirectionalLight sun = new DirectionalLight();
	sun.setDirection(new Vector3f(1,0,-2).normalizeLocal());
	sun.setColor(ColorRGBA.White);
	rootNode.addLight(sun);
	
	createOrientationPoints();
    }

    @Override
    public void render(RenderManager rm) {
	
    }
    
    /**
     * TODO: make sence of this madness
     */
    public void update(float tpf) {
	_tpfHandler.set(tpf);
	for(IBehavior behavior : _behaviors){
	    behavior.execute();
	}
	_sillyCubes.getNode().move(0f, -1f*tpf, 0f);
    }
    
    /** 
     * i get lost to quickly
     * TODO: uhh remove?
     */
    private void createOrientationPoints(){
	
	
	Body map = _bodyFactory.createMap();
	map.getNode().move(-2500, -6000f, -2500f);	
	
	Body justSomeCubes = _bodyFactory.createCubes();
    }

}
