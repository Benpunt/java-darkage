/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviour;

import java.util.Iterator;

/**
 * basic validation functionality, valid on creation. invalid after invalidation
 * @author jappie
 */
public abstract class Validator implements IValid {
    private boolean _valid = true;

    public void invalidate() {
	_valid = false;
    }

    public boolean isValid() {
	return _valid;
    }
    
    public boolean validAction(Iterator executioner){
	if(isValid()){
	    return true;
	}
	executioner.remove();
	return false;
    }
    
}
