/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.State;

import World.Scene.IPhysicalCharacter;
import World.Scene.PhysicalCharacter;
import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;

/**
 *
 * @author jappie
 */
public class PlayerState extends EngineAccesState {
    private IPhysicalCharacter _player;
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
	
	_player = new PhysicalCharacter(
		getEngine().getSpace(), 
		new CharacterControl(new CapsuleCollisionShape(1.5f, 6f, 1), 0.05f));
    }
}
