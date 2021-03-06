/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import java.util.Iterator;

/**
 * basic validation functionality, valid on creation. invalid after invalidation
 * @author jappie
 */
public abstract class Validator implements IValid {
    private boolean _valid = true;
    private int _hashCall = 0;
    private static final int DEFAUTL_INT = 1;
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
    
    @Override
    public boolean equals(Object to){
	if(!(to instanceof Validator)){
	    return false;
	}
	if(isHashComputed()){
	    return true;
	}
	return to.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
	int hash = _hashCall;
	_hashCall++;
	return hash;
    }
    
     public boolean isHashComputed(){
	 return DEFAUTL_INT <= _hashCall;
     }
    
}
