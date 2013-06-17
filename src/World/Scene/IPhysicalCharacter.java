/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import com.jme3.bullet.control.CharacterControl;

/**
 *
 * @author jappie
 */
public interface IPhysicalCharacter extends IPresence{
    CharacterControl getControll();
}
