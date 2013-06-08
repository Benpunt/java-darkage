/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action;

import World.Scene.IBody;
import World.Scene.Shape.IShapeFactory;

/**
 *
 * @author jappie
 */
public class Spawn extends Action{
    private IBody _on;
    private IShapeFactory _from;
    public Spawn(IBody on, IShapeFactory from){
	_on = on;
	_from = from;
    }

    public void execute() {
	_on.add(_from.create());
    }
    
}
