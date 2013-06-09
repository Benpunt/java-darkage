/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Shape;

import World.Factory.IFactory;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;

/**
 *
 * @author jappie
 */
public class ShapeFactory implements IFactory<IShape>{
    Material _material;
    public ShapeFactory(AssetManager assetManager){
	_material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    }
    
    public IShape createCube(){
	Material material = _material.clone();
	material.setColor("Color", ColorRGBA.randomColor());
	return Cube.create(material);
    }

    public IShape create() {
	return createCube();
    }
}
