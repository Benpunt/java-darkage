/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Terrain;

import World.Factory.IFactory;
import com.jme3.math.Vector2f;

/**
 *
 * @author jappie
 */
public interface IHeightMapFactory extends IFactory<float[]> {

    float[] createFromImage();

    /**
     * @param size the _size to set
     */
    void setSize(Vector2f size);
    
}
