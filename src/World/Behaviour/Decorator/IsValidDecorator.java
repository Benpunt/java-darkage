/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.IValid;

/**
 *
 * @author jappie
 */
public abstract class IsValidDecorator extends ValidDecorator{
    public IsValidDecorator(IValid valid){
	super(valid);
    }
    @Override
    public boolean isValid() {
	return getComponent().isValid() & isValidExtension();
    }
    
    /**
     * gets trough an and gate whit its component validness
     * @return 
     */
    abstract boolean isValidExtension();
}
