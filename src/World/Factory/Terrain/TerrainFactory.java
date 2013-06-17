/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Terrain;

import World.Factory.AssetAccesor;
import World.Factory.IFactory;
import com.jme3.asset.AssetManager;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;

/**
 *
 * @author jappie
 */
public class TerrainFactory extends AssetAccesor implements IFactory<TerrainQuad>{
    private String _seed;
    private static final int 
	    DEFAULT_CHUNK_SIZE = 5000,
	    DEFAULT_PATCH_SIZE = 500;
    private int 
	    _size = DEFAULT_CHUNK_SIZE,
	    _patchSize = DEFAULT_PATCH_SIZE;
    
    public TerrainFactory(AssetManager assetManager, String seed){
	super(assetManager);
	_seed = seed;
    }
    public TerrainQuad create() {
	AbstractHeightMap heightmap = new ImageBasedHeightMap(getAsset().loadTexture(
	"Textures/Terrain/splat/mountains512.png").getImage());
	heightmap.load();
	return new TerrainQuad(_seed, _patchSize, _size, heightmap.getHeightMap());
    }

    /**
     * @param size the _size to set
     */
    public void setSize(int size) {
	this._size = size;
    }
    
}
