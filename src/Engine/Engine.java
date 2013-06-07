/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Scene.BodyFactory;
import Scene.Shapes.ShapeFactory;
import UI.EscapeKey;
import UI.ShortcutKeyListener;
import com.jme3.input.KeyInput;
import com.jme3.renderer.RenderManager;


/**
 * This class is an implementation of the vendor engine
 * It handles all my addendums to the world and shows stuff
 * 
 * @author jappie
 */
public class Engine extends VendorEngine {
    
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
	BodyFactory bodyFactory = new BodyFactory(getRootNode(), shapeFactory);
	bodyFactory.createCubes();
    }

    @Override
    public void render(RenderManager rm) {
	
    }
    
    /**
     * TODO: make sence of this madness
     */
    float sum;
    public void update(float tpf) {
    }

}
