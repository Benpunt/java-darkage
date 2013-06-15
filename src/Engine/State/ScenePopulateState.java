/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State;

import Engine.Engine;
import World.Behaviour.Action.Move.Move;
import World.Behaviour.Behavior;
import World.Factory.Scene.BodyFactory;
import World.Factory.Scene.ShapeFactory;
import World.Scene.Visual.Body;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;

/**
 * adds stuff to the scene/world. Initilizes behavior
 * @author jappie
 */
public class ScenePopulateState extends AbstractAppState{
    
    private BodyFactory _bodyFactory;
    private Body _sillyCubes;
    private Engine _engine;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
	
	if(app instanceof Engine){
	    _engine = (Engine) app;
	}else{
	    return;
	}
	
	PhysicsSpace space = stateManager.getState(BulletAppState.class).getPhysicsSpace();
	
	ShapeFactory shapeFactory = new ShapeFactory(_engine.getAssetManager());
	_bodyFactory = new BodyFactory(_engine.getRootNode(), shapeFactory);
	
	Body targetCubes = _bodyFactory.createCubes();
	
	
	_sillyCubes = _bodyFactory.createCubes();
	
	_sillyCubes.move(new Vector3f(0f, 1000f, 0f));
	

	 
	/** Must add a light to make the lit object visible! */
	DirectionalLight sun = new DirectionalLight();
	sun.setDirection(new Vector3f(1,0,-2).normalizeLocal());
	sun.setColor(ColorRGBA.White);
	_engine.getRootNode().addLight(sun);
	
		
	Body map = _bodyFactory.createMap();
	map.getNode().move(-2500, -6000f, -2500f);	
	
	// aperantly you look at the z axis on the begining
	Body justSomeCubes = _bodyFactory.createCubes();
	justSomeCubes.move(new Vector3f(0, 0, 5000f));
	justSomeCubes.getNode().scale(3f);
	
	justSomeCubes = _bodyFactory.createCubes();
	justSomeCubes.move(new Vector3f(0, 0, -5000f));
	justSomeCubes.getNode().scale(3f);

	
	// has to rotate to see it from the center
    	justSomeCubes = _bodyFactory.createCubes();
	justSomeCubes.move(new Vector3f(-5000f, 0, 0));
	justSomeCubes.getNode().rotate(0,(float) (0.5 * Math.PI),0);
	justSomeCubes.getNode().scale(3f);
	
	justSomeCubes = _bodyFactory.createCubes();
	justSomeCubes.move(new Vector3f(5000f, 0, 0));
	justSomeCubes.getNode().rotate(0,(float) (0.5 * Math.PI),0);
	justSomeCubes.getNode().scale(3f);
	
	
	// a nice seeling cross
	justSomeCubes = _bodyFactory.createCubes();
	justSomeCubes.move(new Vector3f(0, 5000f, 450));
	justSomeCubes.getNode().rotate(0,(float) (0.5 * Math.PI),0);
	justSomeCubes.getNode().scale(3f);
	
	justSomeCubes = _bodyFactory.createCubes();
	justSomeCubes.move(new Vector3f(-450, 5000f, 0));
	justSomeCubes.getNode().scale(3f);
	
	initBehavior();
    }
    
    private void initBehavior(){
	_engine.getBehaviors().add(
	    new Behavior(
		new Move(
		    _sillyCubes, 
		    new Vector3f(
			0f, 
			-10f, 
			0f
		    ), 
		    _engine.getTpfHandler()
		)
	    )
	);
	
    }
}
