/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State;

import World.Behaviour.Action.Edit.Behavior.AddBehavior;
import World.Behaviour.Action.IAction;
import World.Behaviour.Action.Move.Move;
import World.Behaviour.Action.Spawn;
import World.Behaviour.Behavior;
import World.Behaviour.Condition.Collision.Collision;
import World.Behaviour.Decorator.ValidOnce;
import World.Factory.IFactory;
import World.Factory.Scene.BodyFactory;
import World.Factory.Scene.ShapeFactory;
import World.Factory.Scene.SolidFactory;
import World.Factory.Terrain.TerrainFactory;
import World.Scene.ISolidBody;
import World.Scene.SolidBody;
import World.Scene.Visual.Body;
import World.Scene.Visual.IBody;
import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainQuad;

/**
 * adds stuff to the scene/world. Initilizes behavior
 * @author jappie
 */
public class ScenePopulateState extends EngineAccesState{
    
    private BodyFactory _bodyFactory;
    private Body _sillyCubes;
    private PhysicsSpace _space;
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
	_space = getEngine().getSpace();
	
	ShapeFactory shapeFactory = new ShapeFactory(getEngine().getAssetManager());
	_bodyFactory = new BodyFactory(getEngine().getRootNode(), shapeFactory);
	SolidFactory solidFactory = new SolidFactory(_space);
	
	TerrainQuad terrain = new TerrainFactory(getEngine().getAssetManager(), "terain").create();
	terrain.setLocalTranslation(0, -100, 0);
	getEngine().getRootNode().attachChild(terrain);
	
	solidFactory.createFromVisual(new Body(terrain));
	 
	/** Must add a light to make the lit object visible! */
	DirectionalLight sun = new DirectionalLight();
	sun.setDirection(new Vector3f(1,0,-2).normalizeLocal());
	sun.setColor(ColorRGBA.White);
	getEngine().getRootNode().addLight(sun);
	//createTestCubes();
    }
    private void createTestCubes(){
		
	_sillyCubes = _bodyFactory.createCubes();
	_sillyCubes.move(new Vector3f(0f, 200f, 0f));
	
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
	
	// some testing behavior
	Behavior onCollision = new Behavior(
	    new Collision(
		_space, 
		_sillyCubes
	    )
	);
	onCollision.add(
	    new Move(
		_sillyCubes, 
		new Vector3f(0f, 2000f, 0f), 
		getEngine().getTpfHandler()
	    )
	);
	onCollision.add(
	
	    new Spawn(
		new Body(getEngine().getRootNode()),
		
		new IFactory<IBody>(){
		    public IBody create() {
			IBody cubes = _bodyFactory.createCubes();
			cubes.add(new Behavior(
				new Move(
				    cubes,
				    new Vector3f(
					0,
					0,
					-0.03f
				    ),
				    getEngine().getTpfHandler()
				)
			    )
			);
			_sillyCubes.add(
			(IAction) // decorator is a behavior by default
			new ValidOnce(
				new AddBehavior(_sillyCubes, cubes)
			)
			);
			return cubes;
		    }
		}
		
	    )
	
	);
	_sillyCubes.add(
	new Behavior(
		new Behavior(
		    new Move(
			_sillyCubes, 
			new Vector3f(
			    0f, 
			    -10f, 
			    0f
			), 
			getEngine().getTpfHandler()
		    )
		),
		onCollision
	    )
	);
	getEngine().getBehaviors().add(
	    _sillyCubes
	);
    }
    

}
