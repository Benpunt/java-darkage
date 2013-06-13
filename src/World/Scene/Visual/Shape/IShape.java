/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Visual.Shape;

import com.jme3.scene.Geometry;

/**
 *
 * @author jappie
 */
public interface IShape {

    /**
     * @return the _shape
     */
    Geometry getShape();

    /**
     * @param shape the _shape to set
     */
    void setShape(Geometry shape);
    
}
