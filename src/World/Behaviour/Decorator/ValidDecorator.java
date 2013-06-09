/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Decorator;

import World.IValid;
import World.Validator;

/**
 *
 * @author jappie
 */
public abstract class ValidDecorator extends Validator{
    private IValid _component;
    public ValidDecorator(IValid component){
	_component = component;
    }

    /**
     * @return the _component
     */
    public IValid getComponent() {
	return _component;
    }
}
