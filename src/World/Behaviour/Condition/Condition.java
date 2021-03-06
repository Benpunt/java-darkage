/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition;

import World.Validator;

/**
 * all conditions should implement this class.
 * @author jappie
 */
public abstract class Condition extends Validator implements ICondition {
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Condition)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	return super.hashCode()*33;
    }
}
