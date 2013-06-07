/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock;

import UI.ShortcutKey;

/**
 *
 * @author jappie
 */
public class ShortcutKeyMock extends ShortcutKey{
    public static String MOCK_NAME = "mock";
    public static int KEY_NUMBER = 1;
    public boolean pressed = false;
    public ShortcutKeyMock(){
	super(MOCK_NAME, KEY_NUMBER);
    }

    @Override
    public void press() {
	pressed = true;
    }
    
}
