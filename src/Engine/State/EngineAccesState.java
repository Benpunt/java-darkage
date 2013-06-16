/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State;

import Engine.Engine;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;

/**
 *
 * @author jappie
 */
public abstract class EngineAccesState  extends AbstractAppState{
    
    private Engine _engine;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
	
	if(app instanceof Engine){
	    _engine = (Engine) app;
	}else{
	    throw new IllegalArgumentException("Could not find the engine in Engineaccesstate");
	}
    }

    /**
     * @return the _engine
     */
    protected Engine getEngine() {
	return _engine;
    }
}
