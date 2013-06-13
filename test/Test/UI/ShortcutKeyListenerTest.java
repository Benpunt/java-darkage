package Test.UI;

import Mock.ShortcutKeyMock;
import Stub.InputManagerStub;
import UI.IInput;
import UI.InputListener;
import com.jme3.input.InputManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class ShortcutKeyListenerTest {
    private InputListener _listenerInstance;
    private ShortcutKeyMock _shortcutKeyMock;
    private InputManagerStub _inputManagerStub;
    public ShortcutKeyListenerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws 
		SecurityException, 
		NoSuchMethodException, 
		InstantiationException, 
		IllegalAccessException, 
		IllegalArgumentException, 
		InvocationTargetException {
	_shortcutKeyMock = new ShortcutKeyMock();
	_inputManagerStub = new InputManagerStub();
	Constructor<InputListener> c = InputListener.class.getDeclaredConstructor(IInput.class);
	c.setAccessible(true);
	
	_listenerInstance = c.newInstance(_shortcutKeyMock);
	System.out.print("ShortcutKeyListenerTest test: ");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of onAction method, of class ShortcutKeyListener.
     */
    @Test
    public void testOnActionHappyPath(){
	
	System.out.println("onAction pressed");
	
	boolean isPressed = true;
	float tpf = 0.0F;
	String name = ShortcutKeyMock.MOCK_NAME;
	
	_listenerInstance.onAction(name, isPressed, tpf);
	Assert.assertTrue(_shortcutKeyMock.pressed);
    }
        /**
     * Test of onAction method, of class ShortcutKeyListener.
     */
    @Test
    public void testOnActionNotPressed(){
	
	System.out.println("onAction not pressed");
	
	boolean isPressed = false;
	float tpf = 0.0F;
	String name = ShortcutKeyMock.MOCK_NAME;
	
	_listenerInstance.onAction(name, isPressed, tpf);
	Assert.assertFalse(_shortcutKeyMock.pressed);
    }
        /**
     * Test of onAction method, of class ShortcutKeyListener.
     */
    @Test
    public void testOnActionWrongKey(){
	
	System.out.println("onAction wrong key");
	
	boolean isPressed = true;
	float tpf = 0.0F;
	String name = ShortcutKeyMock.MOCK_NAME + "hupple fruppel key";
	
	_listenerInstance.onAction(name, isPressed, tpf);
	Assert.assertFalse(_shortcutKeyMock.pressed);
    }

    /**
     * Test of createAndBind method, of class ShortcutKeyListener.
     */
    @Test
    public void testCreateAndBind_InputManager_ShortcutKey_HappyPath() {
	System.out.println("createAndBind");
	
	InputListener.createAndBind(_inputManagerStub, _shortcutKeyMock);
	
	Assert.assertEquals(_listenerInstance, _inputManagerStub._listener);
    }
    
        /**
     * Test of createAndBind method, of class ShortcutKeyListener.
     */
    @Test
    public void testCreateAndBind_InputManager_ShortcutKey_names() {
	System.out.println("createAndBind");
	
	InputListener.createAndBind(_inputManagerStub, _shortcutKeyMock);
	
	Assert.assertEquals(ShortcutKeyMock.MOCK_NAME, _inputManagerStub._keyNames[0]);
    }


}