/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene.Solid;

import World.Behaviour.Behavior;
import World.Scene.Presence;
import com.jme3.scene.control.Control;

/**
 *
 * @author jappie
 */
public class Body extends Presence{
    private World.Scene.Physical.Body _physical;
    private World.Scene.Visual.Body  _visual;
    
    public Body(World.Scene.Physical.Body physical, World.Scene.Visual.Body visual){  
	super(new Behavior(physical, visual));
	_physical = physical;
	_visual = visual;
    }  

    @Override
    public void detach() {
	_physical.detach();
	_visual.detach();
    }
}
