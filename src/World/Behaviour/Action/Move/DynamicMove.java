/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Move;

import Engine.Handler.IReadVector3f;
import Engine.Handler.IReadFloat;

/**
 * Moves as move does, but the vector has to be inside a wrapper wich allows the direction &
 * speed to change.
 * @author jappie
 */
public class DynamicMove extends Move{
    private IReadVector3f _vectorSource;
    public DynamicMove(IMoveable target, IReadVector3f to, IReadFloat tpf){
	super(target, to.getVector(), tpf);
	_vectorSource = to;
    }
    
    @Override
    public void execute(){
	this.setCoordinate(_vectorSource.getVector());
	super.execute();
    }
}
