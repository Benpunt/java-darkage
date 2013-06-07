/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.Engine;

/**
 *
 *  handles what happends if the escape button is pressed
 * 
 * @author jappie
 */
public class EscapeKey extends ShortcutKey {
    private Engine _engine;
    public EscapeKey(String name, int key, Engine engine){
	super(name, key);
	_engine = engine;
    }
    @Override
    public void press() {
	_engine.stop();
    }
    
}
