/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock;

import UI.Input;

/**
 *
 * @author jappie
 */
public class ShortcutKeyMock extends Input{
    public static String MOCK_NAME = "mock";
    public static int KEY_NUMBER = 1;
    public boolean pressed = false;
    public ShortcutKeyMock(){
	// for now this will suffice but if the keytrigger is actualy gonna be used in 
	// the real shorcutkey class. Then this class needs to extend the interface
	super(MOCK_NAME, KEY_NUMBER);
    }

    @Override
    public void press() {
	pressed = true;
    }

    public void press(float value) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
