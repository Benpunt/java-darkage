/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock.Behaviour;

import World.IValid;
import java.util.Iterator;

/**
 *
 * @author jappie
 */
public class ValidationMock implements IValid{
    
    public boolean 
	    _invalidateCalled = false,
	    _invalidateCallValue =true,
	    _isValid = true,
	    _validAction = true;
    public Iterator _givenIterator = null;

    public void invalidate() {
	_invalidateCalled = _invalidateCallValue;
    }

    public boolean isValid() {
	return _isValid;
    }

    public boolean validAction(Iterator executioner) {
	_givenIterator = executioner;
	return _validAction;
    }
    @Override
    public boolean equals(Object to){
	return (to instanceof ValidationMock);
    }

    @Override
    public int hashCode() {
	return 1;
    }

    public boolean isHashComputed() {
	return true;
    }
}
