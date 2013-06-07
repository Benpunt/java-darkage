/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.State.CameraState;
import Engine.State.Stats;
import com.jme3.app.Application;
import com.jme3.app.state.AppState;
import com.jme3.font.BitmapFont;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.system.AppSettings;

/**
 * This class is a replacement for the simple aplication of jme3 
 * I found their naming stupid but most of the code below is stolen directly from them.
 * 
 * I set it up in such a way that all the code i written is in the Engine class
 * wich is an implementation of this class.
 * 
 * so the vendor stands for jme3
 * 
 * @author jme3, sort off
 */
public abstract class VendorEngine extends Application {
    
    private Camera _camera;
    private Node _rootNode = new Node("Root Node");
    private Node _guiNode = new Node("Gui Node");
    private BitmapFont _guiFont;
    public VendorEngine() {
	this(new Stats(), new CameraState());
    }

    public VendorEngine(AppState... initialStates) {
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

	getGuiNode().setQueueBucket(Bucket.Gui);
	getGuiNode().setCullHint(CullHint.Never);
	viewPort.attachScene(getRootNode());
	guiViewPort.attachScene(getGuiNode());
	_camera = new Camera(cam); // usage of my own camare class gives me more power
	_camera.setMoveSpeed(10f);

	if (stateManager.getState(CameraState.class) != null) {
	    stateManager.getState(CameraState.class).setCamera(_camera);
	}
	if (stateManager.getState(Stats.class) != null) {

	    stateManager.getState(Stats.class).setFont(_guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt"));
	}
	init();
    }
    
    
    public abstract void init();

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

	getRootNode().updateLogicalState(tpf);
	getGuiNode().updateLogicalState(tpf);
	getRootNode().updateGeometricState();
	getGuiNode().updateGeometricState();

	// render states
	stateManager.render(renderManager);
	renderManager.render(tpf, context.isRenderable());
	render(renderManager);
	stateManager.postRender();
    }
    
    public abstract void update(float tpf);

    public abstract void render(RenderManager rm);

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

    /**
     * @return the _rootNode
     */
    public Node getRootNode() {
	return _rootNode;
    }

}
