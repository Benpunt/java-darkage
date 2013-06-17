/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory;

import com.jme3.asset.AssetManager;

/**
 *
 * @author jappie
 */
public abstract class AssetAccesor {
    private AssetManager _asset;
    
    public AssetAccesor(AssetManager assetManager){
	_asset = assetManager;
    }

    /**
     * @return the _asset
     */
    public AssetManager getAsset() {
	return _asset;
    }
}
