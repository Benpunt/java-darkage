/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import World.Factory.IFactory;
import World.Scene.Visual.IBody;
import com.jme3.scene.Node;

/**
 *
 * @author jappie
 */
public class Spawn extends Action{
    private IBody _on;
    private IFactory<IBody> _factory;
    
    /**
     * the factory interface is probably best used as an ananymous class decleration
     * @param on
     * @param factory 
     */
    public Spawn(IBody on, IFactory<IBody> factory){
	_on = on;
	_factory = factory;
    }

    public void execute() {
	_on.add(_factory.create());
    }
    
}
