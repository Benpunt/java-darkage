/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import World.Scene.Body;
import World.Scene.BodyFactory;
import World.Scene.Shape.ShapeFactory;
import UI.EscapeKey;
import UI.ShortcutKeyListener;
import com.jme3.input.KeyInput;
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
    @Override
    public void init() {
	ShortcutKeyListener.createAndBind(
	    inputManager, 
	    new EscapeKey(
		"Escape", 
		KeyInput.KEY_ESCAPE, 
		this
	    )
	);
	ShapeFactory shapeFactory = new ShapeFactory(assetManager);
	bodyFactory = new BodyFactory(getRootNode(), shapeFactory);
	_bodies = new ArrayList<Body>();
	_bodies.add(bodyFactory.createCubes());
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
	
	sum = (sum+tpf) % threshold;
	if((sum + tpf) > threshold){
	    _bodies.add(bodyFactory.createCubes());
	}
	for(Body body : _bodies){
	    body.getNode().move(0,tpf/threshold+0.005f,0);
	}
    }

}
