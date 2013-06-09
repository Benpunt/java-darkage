/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import World.Factory.IFactory;
import World.Scene.IBody;
import World.Scene.Shape.IShape;

/**
 *
 * @author jappie
 */
public class Spawn extends Action{
    private IBody _on;
    private IFactory<IShape> _from;
    public Spawn(IBody on, IFactory<IShape> from){
	_on = on;
	_from = from;
    }

    public void execute() {
	_on.add(_from.create());
    }
    
}
