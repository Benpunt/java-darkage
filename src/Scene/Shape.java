/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import Exception.CompositionException;
import com.jme3.scene.Geometry;

/**
 *
 * @author jappie
 */
public abstract class Shape {
    private Geometry _shape;
    
    public Shape(Geometry shape){
	checkShape(shape);
	_shape = shape;
    }

    /**
     * @return the _shape
     */
    public Geometry getShape() {
	return _shape;
    }

    /**
     * @param shape the _shape to set
     */
    public void setShape(Geometry shape) {
	checkShape(shape);
	this._shape = shape;
    }
    
    private void checkShape(Geometry shape){
	CompositionException.Check(shape, "shape", "geometry");
    }
}
