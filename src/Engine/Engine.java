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
import World.Factory.Scene.BodyFactory;
import World.Factory.Scene.ShapeFactory;
import World.Scene.Visual.Body;
import com.jme3.input.KeyInput;
import com.jme3.math.ColorRGBA;
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
    BodyFactory bodyFactory;
    List<Body> _bodies;
    IFloatHandler _tpfHandler;
    
    @Override
    public void init() {
	InputListener.createAndBind(
		inputManager,
		new BehavioredInput("Escape", new Stop(this), KeyInput.KEY_ESCAPE)
	);
	viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
	
	_tpfHandler = new FloatHandler();
	
	ShapeFactory shapeFactory = new ShapeFactory(assetManager);
	bodyFactory = new BodyFactory(getRootNode(), shapeFactory);
	_bodies = new ArrayList<Body>();
	_bodies.add(bodyFactory.createCubes());
	bodyFactory.createMap();
    }

    @Override
    public void render(RenderManager rm) {
	
    }
    
    /**
     * TODO: make sence of this madness
     */
    float sum;
    int threshold = 10;
    int distance = 1;
    public void update(float tpf) {
	_tpfHandler.set(tpf);
	
	sum = (sum+tpf) % threshold;
	if((sum + tpf) > threshold){
	    _bodies.add(bodyFactory.createCubes());
	}
	for(Body body : _bodies){
	    body.getNode().move(0,tpf/threshold+0.005f,0);
	}
    }

}
