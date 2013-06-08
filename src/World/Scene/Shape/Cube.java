/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Shape;

import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author jappie
 */
public class Cube extends Shape {
    public static String NAME = "Cube";
    protected Cube(Geometry shape){
	super(shape);
    }

    public static Shape create(Material from) {
	Box box = new Box(Vector3f.ZERO, 1, 1, 1);
	Geometry geometry = new Geometry(NAME, box);
	geometry.setMaterial(from);
	return new Cube(geometry);
    }
    
}
