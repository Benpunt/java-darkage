/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Terrain;

import World.Factory.AssetAccesor;
import World.Factory.IFactory;
import com.jme3.asset.AssetManager;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import java.util.ArrayList;

/**
 *
 * @author jappie
 */
public class HeightMapFactory extends AssetAccesor implements IFactory<float[]>{
    

    public HeightMapFactory(AssetManager assetManager){
	super(assetManager);
    }
    
    public float[] create() {
	AbstractHeightMap heightmap = new ImageBasedHeightMap(getAsset().loadTexture(
		"Textures/Terrain/splat/mountains512.png").getImage());
	heightmap.load();
	return heightmap.getHeightMap();
    }
    public float[] createFromImage() {
	AbstractHeightMap heightmap = new ImageBasedHeightMap(getAsset().loadTexture(
		"Textures/Terrain/splat/mountains512.png").getImage());
	heightmap.load();
	return heightmap.getHeightMap();
    }
    
}
