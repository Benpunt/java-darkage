/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Camera;

import com.jme3.input.FlyByCamera;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;

/**
 *
 * @author jappie
 */
public class CameraAcces extends FlyByCamera{
    public CameraAcces(Camera cam){
        super(cam);
    }
    public Vector3f getLeft(){
	return cam.getLeft();
    }
    public Vector3f getUp(){
	return initialUpVec;
    }
    
    public boolean isYInverted(){
	return invertY;
    }
    
    @Override
    public void rotateCamera(float value, Vector3f axis){
        super.rotateCamera(value, axis);
    }

    @Override
    public void zoomCamera(float value){
        super.zoomCamera(value);
    }

    @Override
    public void riseCamera(float value){
        super.riseCamera(value);
    }

    @Override
    public void moveCamera(float value, boolean sideways){
        super.moveCamera(value, sideways);
    }    
}
