/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import com.jme3.input.FlyByCamera;

/**
 * this class contains logic about camera movement.
 * It allows flybycamera behavior to be overwritten.
 * 
 * the engine class has acces to a com.jme3 camera...
 * 
 * @author jappie
 */
public class Camera extends FlyByCamera{
    public Camera(com.jme3.renderer.Camera Cam){
	super(Cam);
    }
}
