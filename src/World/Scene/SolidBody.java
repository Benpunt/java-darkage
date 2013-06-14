/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.Behavior;
import World.Scene.Presence;
import com.jme3.scene.control.Control;

/**
 *
 * @author jappie
 */
public class SolidBody extends Presence{
    private World.Scene.PhysicalBody _physical;
    private World.Scene.Visual.Body  _visual;
    
    public SolidBody(World.Scene.PhysicalBody physical, World.Scene.Visual.Body visual){  
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
