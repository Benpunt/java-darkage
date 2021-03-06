/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Terrain;

import World.Factory.AssetAccesor;
import World.Factory.IFactory;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.Vector2f;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;

/**
 *
 * @author jappie
 */
public class TerrainFactory extends AssetAccesor implements IFactory<TerrainQuad> {
    private static final int STRECTCH = 80;
    private static final int NOISE_ACCENT = 1;
    private String _seed;
    private IHeightMapFactory _heightMapFactory;
    private static final int DEFAULT_CHUNK_SIZE = 513,
	    DEFAULT_PATCH_SIZE = 257;
    private int _size = DEFAULT_CHUNK_SIZE,
	    _patchSize = DEFAULT_PATCH_SIZE;

    public TerrainFactory(AssetManager assetManager, String seed) {
	super(assetManager);
	_seed = seed;
	_heightMapFactory = new HeightMapFactory(assetManager, seed, new Vector2f(_size, _size));
    }

    public TerrainQuad create() {

	TerrainQuad terrain = new TerrainQuad(_seed, _patchSize, _size, _heightMapFactory.create());
	terrain.setMaterial(createMaterial());
	terrain.setLocalScale(STRECTCH, NOISE_ACCENT, STRECTCH);
	return terrain;
    }

    /**
     * @param size the _size to set
     */
    public void setSize(int size) {
	this._size = size;
	_heightMapFactory.setSize(new Vector2f(size, size));
    }

    private Material createMaterial() {
	/**
	 * 1. Create terrain material and load four textures into it.
	 */
	Material material = new Material(getAsset(),
		"Common/MatDefs/Terrain/Terrain.j3md");

	/**
	 * 1.1) Add ALPHA map (for red-blue-green coded splat textures)
	 */
	material.setTexture("Alpha", getAsset().loadTexture(
		"Textures/Terrain/splat/alphamap.png"));

	/**
	 * 1.2) Add GRASS texture into the red layer (Tex1).
	 */
	Texture grass = getAsset().loadTexture(
		"Textures/Terrain/splat/grass.jpg");
	grass.setWrap(WrapMode.Repeat);
	material.setTexture("Tex1", grass);
	material.setFloat("Tex1Scale", 64f);

	/**
	 * 1.3) Add DIRT texture into the green layer (Tex2)
	 */
	Texture dirt = getAsset().loadTexture(
		"Textures/Terrain/splat/dirt.jpg");
	dirt.setWrap(WrapMode.Repeat);
	material.setTexture("Tex2", dirt);
	material.setFloat("Tex2Scale", 32f);

	/**
	 * 1.4) Add ROAD texture into the blue layer (Tex3)
	 */
	Texture rock = getAsset().loadTexture(
		"Textures/Terrain/splat/road.jpg");
	rock.setWrap(WrapMode.Repeat);
	material.setTexture("Tex3", rock);
	material.setFloat("Tex3Scale", 128f);
	
	return material;
    }
}
