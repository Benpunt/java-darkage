/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import GUI.EscapeKey;
import GUI.ShortcutKeyListener;
import com.jme3.input.KeyInput;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;


/**
 * This class is an implementation of the vendor engine
 * It handles all my addendums to the world and shows stuff
 * 
 * @author jappie
 */
public class Engine extends VendorEngine {
    Geometry geom, geoc;
    Node cubeNode = new Node("cubeSpatial");
    
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
		Box b = new Box(Vector3f.ZERO, 1, 1, 1);
	Box c = new Box(Vector3f.ZERO, 3, 2, 5);
	
	geom = new Geometry("Box", b);
	geoc = new Geometry("Boxc", c);

	Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	mat.setColor("Color", ColorRGBA.Blue);
	geom.setMaterial(mat);
	
	Material sad = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	sad.setColor("Color", ColorRGBA.Red);
	
	geoc.setMaterial(sad);
	
	geoc.move(2, 3, 2);
	cubeNode.attachChild(geom);
	cubeNode.attachChild(geoc);
	
	getRootNode().attachChild(cubeNode);
    }

    @Override
    public void render(RenderManager rm) {
	
    }
    
    /**
     * TODO: make sence of this madness
     */
    float sum;
    public void update(float tpf) {

	sum += tpf;
	float sine = (float)Math.sin(sum)/10;
	geom.move(0.01f, sine, 0f);
	geoc.move(sine, 0, sine);
	cubeNode.rotate(0.001f, 0.0001f, 0.0001f);
	geoc.rotate(0.001f, -0.0001f, -0.0001f);
    }

}
