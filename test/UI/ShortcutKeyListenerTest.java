package UI;

import Mock.ShortcutKeyMock;
import com.jme3.input.InputManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
    private ShortcutKeyListener instance;
    private ShortcutKeyMock mock;
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
	mock = new ShortcutKeyMock();
	
	Constructor<ShortcutKeyListener> c = ShortcutKeyListener.class.getDeclaredConstructor(ShortcutKey.class);
	c.setAccessible(true);
	
	instance = c.newInstance(mock);
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
	
	instance.onAction(name, isPressed, tpf);
	Assert.assertTrue(mock.pressed);
    }
        /**
     * Test of onAction method, of class ShortcutKeyListener.
     */
    @Test
    public void testOnActionNotPressed(){
	
	System.out.println("onAction pressed");
	
	boolean isPressed = false;
	float tpf = 0.0F;
	String name = ShortcutKeyMock.MOCK_NAME;
	
	instance.onAction(name, isPressed, tpf);
	Assert.assertFalse(mock.pressed);
    }
        /**
     * Test of onAction method, of class ShortcutKeyListener.
     */
    @Test
    public void testOnActionWrongKey(){
	
	System.out.println("onAction pressed");
	
	boolean isPressed = true;
	float tpf = 0.0F;
	String name = ShortcutKeyMock.MOCK_NAME + "hupple fruppel key";
	
	instance.onAction(name, isPressed, tpf);
	Assert.assertFalse(mock.pressed);
    }

    /**
     * Test of createAndBind method, of class ShortcutKeyListener.
     
    @Test
    public void testCreateAndBind_InputManager_ArrayList() {
	System.out.println("createAndBind");
	InputManager manager = null;
	ArrayList<ShortcutKey> keys = null;
	ShortcutKeyListener.createAndBind(manager, keys);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of createAndBind method, of class ShortcutKeyListener.
     
    @Test
    public void testCreateAndBind_InputManager_ShortcutKey() {
	System.out.println("createAndBind");
	InputManager manager = null;
	ShortcutKey key = null;
	ShortcutKeyListener.createAndBind(manager, key);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    */

}