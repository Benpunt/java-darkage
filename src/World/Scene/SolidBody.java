/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import World.Behaviour.Behavior;
import World.Scene.Visual.Body;

/**
 *
 * @author jappie
 */
public class SolidBody extends Presence{
    private PhysicalBody _physical;
    private Body  _visual;
    
    public SolidBody(PhysicalBody physical, Body visual){  
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
