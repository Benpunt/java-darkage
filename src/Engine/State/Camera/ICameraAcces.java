/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State.Camera;

import Engine.State.Camera.CameraAcces.CamAction;
import World.Behaviour.Action.Move.IMoveable;
import World.Behaviour.Action.Move.ITeleportable;
import World.Behaviour.IBehavior;
import com.jme3.collision.MotionAllowedListener;
import com.jme3.input.InputManager;
import com.jme3.math.Vector3f;
import java.util.Map;

/**
 *defines a slightly improved interface for flybycam & offers a little more acces to things
 * @see com.jme3.input.FlyByCamera
 * @author jappie
 */
public interface ICameraAcces extends Map<CamAction, IBehavior>, IMoveable, ITeleportable {
    public void setUpVector(Vector3f upVec);

    public void setMotionAllowedListener(MotionAllowedListener listener);

    /**
     * Sets the move speed. The speed is given in world units per second.
     * @param moveSpeed
     */
    public void setMoveSpeed(float moveSpeed);
    
    /**
     * Gets the move speed. The speed is given in world units per second.
     * @return moveSpeed
     */
    public float getMoveSpeed();

    /**
     * Sets the rotation speed.
     * @param rotationSpeed
     */
    public void setRotationSpeed(float rotationSpeed);
    
    /**
     * Gets the move speed. The speed is given in world units per second.
     * @return rotationSpeed
     */
    public float getRotationSpeed();
    /**
     * Sets the zoom speed.
     * @param zoomSpeed 
     */
    public void setZoomSpeed(float zoomSpeed);
    /**
     * Gets the zoom speed.  The speed is a multiplier to increase/decrease
     * the zoom rate.
     * @return zoomSpeed
     */
    public float getZoomSpeed();

    /**
     * @param enable If false, the camera will ignore input.
     */
    public void setEnabled(boolean enable);

    /**
     * @return If enabled
     * @see FlyByCamera#setEnabled(boolean)
     */
    public boolean isEnabled();

    /**
     * @return If drag to rotate feature is enabled.
     *
     * @see FlyByCamera#setDragToRotate(boolean) 
     */
    public boolean isDragToRotate();
    /**
     * Set if drag to rotate mode is enabled.
     * 
     * When true, the user must hold the mouse button
     * and drag over the screen to rotate the camera, and the cursor is
     * visible until dragged. Otherwise, the cursor is invisible at all times
     * and holding the mouse button is not needed to rotate the camera.
     * This feature is disabled by default.
     * 
     * @param dragToRotate True if drag to rotate mode is enabled.
     */
    public void setDragToRotate(boolean dragToRotate);

    /**
     * my replacement for register with input. It uses behavior.
     * @see com.jme3.input.FlyByCamera
     * @param inputManager
     */
    public void registerInput(InputManager inputManager);
    public void unregisterInput();
    public void rotateCamera(float value, Vector3f axis);
    public void zoomCamera(float value);
    public void riseCamera(float value);
    public void moveCamera(float value, boolean sideways);
    
    public Vector3f getDirection();
    public Vector3f getLeft();
}
