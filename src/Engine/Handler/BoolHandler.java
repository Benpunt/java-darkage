/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Handler;

/**
 *
 * @author jappie
 */
public class BoolHandler implements IBoolHandler {
    private static final boolean DEFAULT_VALUE = false;
    private boolean _bool;
    
    public BoolHandler(){
	_bool = DEFAULT_VALUE; Boolean value = false;
    }
    
    public BoolHandler(boolean value){
	_bool = value;
    }

    /**
     * @return the _bool
     */
    @Override
    public boolean is() {
	return _bool;
    }

    /**
     * @param bool the _bool to set
     */
    @Override
    public void set(boolean bool) {
	_bool = bool;
    }
}
