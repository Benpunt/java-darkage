/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Action.Camera;

import Engine.State.Camera.CameraAcces;

/**
 * stores the cameras current rotate & movement speed & sets it to 0 on next call
 * @author jappie
 */
public class CameraAbleSwitch extends CameraAction{
    float _moveSpeed;
    float _rotateSpeed;
    public CameraAbleSwitch(CameraAcces camera){
	super(camera);
	_moveSpeed = camera.getMoveSpeed();
	_rotateSpeed = camera.getRotationSpeed();
    }

    public void execute() {
	if(_moveSpeed == getCamera().getMoveSpeed() && _rotateSpeed == getCamera().getRotationSpeed()){
	    
	    // might have changed since initilization so remember before i forget
	    _moveSpeed = getCamera().getMoveSpeed();
	    _rotateSpeed = getCamera().getRotationSpeed();
	    
	    getCamera().setRotationSpeed(0);
	    getCamera().setMoveSpeed(0);
	    
	}else{
	    getCamera().setMoveSpeed(_moveSpeed);
	    getCamera().setRotationSpeed(_rotateSpeed);
	}
    }
}
