/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Terrain;

import Engine.Log;
import World.Factory.AssetAccesor;
import com.jme3.asset.AssetManager;
import com.jme3.math.Vector2f;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;

/**
 *
 * @author jappie
 */
public class HeightMapFactory extends AssetAccesor implements IHeightMapFactory{
    private Noise _noise;
    private Vector2f _size;

    public HeightMapFactory(AssetManager assetManager, String seed, Vector2f size){
	super(assetManager);
	int hasCode = seed.hashCode()+100;
	Log.debug("Creating noise for the heightmap with seed: {0}", hasCode);
	_noise = new Noise(hasCode);
	_size = size;
    }
    
    public float[] create() {
	float[] value = new float[Math.round(_size.x * _size.y)];
	
	for(int x = 0; x < _size.x; x++){
	    for(int y = 0; y < _size.y; y++){
		value[Math.round(x*_size.x + y)] = _noise.turbulence2(x, y, 1000)*50;
	    }
	}
	return value;
    }
    @Override
    public float[] createFromImage() {
	AbstractHeightMap heightmap = new ImageBasedHeightMap(getAsset().loadTexture(
		"Textures/Terrain/splat/mountains512.png").getImage());
	heightmap.load();
	return heightmap.getHeightMap();
    }

    /**
     * @param size the _size to set
     */
    @Override
    public void setSize(Vector2f size) {
	this._size = size;
    }
    
}
