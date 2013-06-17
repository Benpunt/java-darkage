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
public interface IVector3fHandler extends IReadVector3f {

    /**
     * @param vector the _vector to set
     */
    void setVector(Vector3f vector);
    
}
