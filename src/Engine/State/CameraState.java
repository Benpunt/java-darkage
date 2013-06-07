/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State;

import Engine.Camera;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;

/**
 * jme3 works trough the state pattern. Wich i find quite horibble but they
 * must have had good reasons to use it. Those people are certainly not stupid
 * 
 * this class is needed to replace the simpleaplication class. I found their naming
 * anoying. Besides 80 chars per rule is for 800x600 screens
 * 
 * @author jappie
 */
public class CameraState extends AbstractAppState {

    private Application app;
    private Camera Camera;

    public CameraState() {
    }    

    /**
     *  This is called by SimpleApplication during initialize().
     */
    public void setCamera( Camera cam ) {
        this.Camera = cam;
    }
    
    public Camera getCamera() {
        return Camera;
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        
        this.app = app;

        if (app.getInputManager() != null) {
        
            if (Camera == null) {
                Camera = new Camera(app.getCamera());
            }
            
            Camera.registerWithInput(app.getInputManager());            
        }               
    }
            
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        
        Camera.setEnabled(enabled);
    }
    
    @Override
    public void cleanup() {
        super.cleanup();

        Camera.unregisterInput();        
    }


}
