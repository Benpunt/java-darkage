package Test.Behaviour;

import Behaviour.Action.IAction;
import Behaviour.Behavior;
import Behaviour.Condition.ICondition;
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
public class BehaviorTest {

    public BehaviorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
	System.out.print("BehaviorTest test: ");
    }

    @After
    public void tearDown() {
    }
    /**
     * Test of Execute method, of class Behavior.
     */
    @Test
    public void testExecute() {
	System.out.println("Execute");
	Behavior instance = new Behavior();
	instance.Execute();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of isSufficient method, of class Behavior.
     */
    @Test
    public void testIsSufficient() {
	System.out.println("isSufficient");
	Behavior instance = new Behavior();
	boolean expResult = false;
	boolean result = instance.isSufficient();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}