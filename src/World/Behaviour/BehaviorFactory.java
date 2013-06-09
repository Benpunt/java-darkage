/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour;

import World.Factory.Factory;
import World.Factory.IFactory;

/**
 *
 * @author jappie
 */
public class BehaviorFactory extends Factory<IBehavior> implements IFactory<IBehavior>{
    public BehaviorFactory(){
	super(Behavior.class);
    }
}
