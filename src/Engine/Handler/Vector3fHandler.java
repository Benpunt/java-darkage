/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Handler;

import com.jme3.math.Vector3f;

/**
 *
 * @author jappie
 */
public class Vector3fHandler implements IVector3fHandler{
    private static final Vector3f DEFAULT_VALUE = Vector3f.ZERO;
    private Vector3f _value;
    
    public Vector3fHandler(){
	_value = DEFAULT_VALUE;
    }
    
    public Vector3fHandler(Vector3f value){
	_value = value;
    }
    /**
     * @return the _vector
     */
    public Vector3f getVector() {
	return _value;
    }

    /**
     * @param vector the _vector to set
     */
    @Override
    public void setVector(Vector3f vector) {
	this._value = vector;
    }
}
