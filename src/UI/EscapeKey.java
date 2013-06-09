/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Engine.Engine;
import com.jme3.input.KeyInput;

/**
 *
 *  handles what happends if the escape button is pressed
 * 
 * @author jappie
 */
public class EscapeKey extends ShortcutKey {
    private Engine _engine;
    public EscapeKey(String name, Engine engine){
	super(name, KeyInput.KEY_ESCAPE);
	_engine = engine;
    }
    @Override
    public void press() {
	_engine.stop();
    }
    
}
