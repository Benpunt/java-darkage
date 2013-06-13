/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.Camera.CameraState;
import com.jme3.app.DebugKeysAppState;
import com.jme3.app.FlyCamAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.app.StatsAppState;
import com.jme3.bullet.BulletAppState;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;

/**
 * This class overwites settings from simpleaplication
 * it was recomended to extend it.
 * 
 * so the vendor stands for jme3
 * 
 * @author jme3, sort off
 */
public abstract class VendorEngine extends SimpleApplication {
    
    public VendorEngine(){
	super(new StatsAppState(), new CameraState(), new BulletAppState());
    }
    
    public abstract void init();
    
    public abstract void update(float tpf);

    public abstract void render(RenderManager rm);
    @Override
    public void start() {
	showSettings = false;
        AppSettings settings = new AppSettings(true);
	settings.setWidth(1900);
	settings.setHeight(1080);
        setSettings(settings);
        super.start();
	
    }    
    /**
     * overides some of the bullshit of simple aplication
     */
    @Override
    public void simpleInitApp() {
	init();
    }
    
    @Override
    public void simpleUpdate(float tpf) {
	update(tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
	render(rm);
    }
}
