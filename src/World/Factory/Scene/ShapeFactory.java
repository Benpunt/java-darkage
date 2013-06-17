/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Scene;

import World.Factory.IFactory;
import World.Scene.Visual.Shape.Cube;
import World.Scene.Visual.Shape.IShape;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;

/**
 *
 * @author jappie
 */
public class ShapeFactory implements IFactory<IShape>{
    private Material _material;
    Texture _map;
    public ShapeFactory(AssetManager assetManager){
	_map = assetManager.loadTexture("Textures/map.png");
	_material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    }
    
    public IShape createCube(){
	Material material = getMaterial();
	material.setColor("Color", ColorRGBA.randomColor());
	return Cube.create(material);
    }
    
    public IShape createMapCube(){
	Material material = getMaterial();
	material.setTexture("ColorMap", _map);
	material.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
	return Cube.create(material, new Vector3f(1,1,1), new Vector3f(5000, 5000, 5000));
    }

    public IShape create() {
	return createCube();
    }

    /** bad idea to give visuals same material
     * @return the _material
     */
    public Material getMaterial() {
	return _material.clone();
    }
    
    public IShape createFloor(){
	Material material = getMaterial();
	material.setColor("Color", ColorRGBA.randomColor());
	return Cube.create(material,  new Vector3f(1,1,1), new Vector3f(5000, 1.5f, 5000));
    }
}
