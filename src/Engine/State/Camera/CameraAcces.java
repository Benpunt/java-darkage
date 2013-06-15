/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State.Camera;

import com.jme3.input.FlyByCamera;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;

/**
 *
 * @author jappie
 */
public class CameraAcces extends FlyByCamera{
    private float _farSight = 1000f;
    private float _nearSight = 1f;
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
    
    public void setFarSight(float value){
	_farSight = value;
	updateFrustrum();
    }
    public void setFarNearSight(float value){
	_nearSight = value;
	updateFrustrum();
    }
    
    private void updateFrustrum(){
	cam.setFrustumPerspective(45f, (float)cam.getWidth() / cam.getHeight(), _nearSight, _farSight);
    }
}
