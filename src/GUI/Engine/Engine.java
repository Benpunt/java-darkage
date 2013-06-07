/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Engine;

import GUI.Engine.State.CameraState;
import GUI.Engine.State.Stats;
import GUI.EscapeKey;
import GUI.ShortcutKey;
import GUI.ShortcutKeyListener;
import com.jme3.app.Application;
import com.jme3.app.DebugKeysAppState;
import com.jme3.app.state.AppState;
import com.jme3.font.BitmapFont;
import com.jme3.input.KeyInput;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import java.util.ArrayList;

/**
 * This class contains the logic to start up the 3d engine
 *
 * @author jappie
 */
public class Engine extends Application {
    
    private Camera _camera;
    private Node _rootNode = new Node("Root Node");
    private Node _guiNode = new Node("Gui Node");
    private BitmapFont _guiFont;
    public Engine() {
	this(new Stats(), new CameraState(), new DebugKeysAppState());
    }

    public Engine(AppState... initialStates) {
	super();

	if (initialStates != null) {
	    for (AppState a : initialStates) {
		if (a != null) {
		    stateManager.attach(a);
		}
	    }
	}
    }

    @Override
    public void initialize() {
	super.initialize();
	ShortcutKeyListener.createAndBind(
	    inputManager, 
	    new EscapeKey(
		"Escape", 
		KeyInput.KEY_ESCAPE, 
		this
	    )
	);

	getGuiNode().setQueueBucket(Bucket.Gui);
	getGuiNode().setCullHint(CullHint.Never);
	viewPort.attachScene(_rootNode);
	guiViewPort.attachScene(getGuiNode());
	_camera = new Camera(cam);
	_camera.setMoveSpeed(10f);

	if (stateManager.getState(CameraState.class) != null) {
	    stateManager.getState(CameraState.class).setCamera(_camera);
	}
	if (stateManager.getState(Stats.class) != null) {

	    stateManager.getState(Stats.class).setFont(_guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt"));
	}
	loadScenery();
    }

    public void loadScenery() {
	Box b = new Box(Vector3f.ZERO, 1, 1, 1);
	Box c = new Box(Vector3f.ZERO, 3, 2, 5);
	Geometry geom = new Geometry("Box", b), geoc = new Geometry("Boxc", c);
	

	Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	mat.setColor("Color", ColorRGBA.Blue);
	geom.setMaterial(mat);
	
	Material sad = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	sad.setColor("Color", ColorRGBA.Red);
	
	geoc.setMaterial(sad);
	
	geoc.move(2, 3, 2);
	_rootNode.attachChild(geom);
	_rootNode.attachChild(geoc);
    }

    @Override
    public void start() {
	setSettings(new AppSettings(true));
	super.start();
    }

    @Override
    public void update() {
	super.update(); // makes sure to execute AppTasks
	if (speed == 0 || paused) {
	    return;
	}

	float tpf = timer.getTimePerFrame() * speed;

	// update states
	stateManager.update(tpf);

	// simple update and root node
	update(tpf);

	_rootNode.updateLogicalState(tpf);
	getGuiNode().updateLogicalState(tpf);
	_rootNode.updateGeometricState();
	getGuiNode().updateGeometricState();

	// render states
	stateManager.render(renderManager);
	renderManager.render(tpf, context.isRenderable());
	render(renderManager);
	stateManager.postRender();
    }

    public void update(float tpf) {
    }

    public void render(RenderManager rm) {
    }

    /**
     * @return the guiFont
     */
    public BitmapFont getGuiFont() {
	return _guiFont;
    }
    
    /**
     * @return the guiNode
     */
    public Node getGuiNode() {
	return _guiNode;
    }

}
