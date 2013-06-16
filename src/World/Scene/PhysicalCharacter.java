/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import Exception.CompositionException;
import World.Behaviour.IBehavior;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;

/**
 *
 * @author jappie
 */
public class PhysicalCharacter extends PhysicsAcces implements IPhysicalCharacter {
    private CharacterControl _character;
    public PhysicalCharacter(PhysicsSpace space, CharacterControl character, IBehavior behavior){
	super(space, behavior);
	check(character);
	_character = character;
	getSpace().add(_character);
    }
    private void check(CharacterControl shape){
	CompositionException.Check(shape, "Physical.character", "CharacterControl");
    }
    public void detach() {
	getSpace().remove(_character);
    }

    public void move(Vector3f to) {
	_character.setWalkDirection(to);
    }

    public void setLocation(Vector3f where) {
	_character.setPhysicsLocation(where);
    }
    
}
