/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Visual.Shape;

import Exception.CompositionException;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;

/**
 *
 * @author jappie
 */
public abstract class Shape implements IShape {
    protected Geometry _shape;
    protected Shape(Geometry shape){
	checkShape(shape);
	_shape = shape;
    }

    /**
     * @return the _shape
     */
    @Override
    public Geometry getShape() {
	return _shape;
    }

    /**
     * @param shape the _shape to set
     */
    @Override
    public void setShape(Geometry shape) {
	checkShape(shape);
	this._shape = shape;
    }
    
    private void checkShape(Geometry shape){
	CompositionException.Check(shape, "shape", "geometry");
    }
}
