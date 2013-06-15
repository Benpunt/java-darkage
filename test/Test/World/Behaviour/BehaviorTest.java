package Test.World.Behaviour;

import Test.World.BehaviortestMocks;
import World.Behaviour.Behavior;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * tests the behavior of the behavior class...
 * Some behaviors need to be hard coded like code only gets executed if the conditions suffice.
 * This is also true for sub behavior, because then you can both create gaurded sub behaviors
 * as always executed sub behavior.
 * @author jappie
 */
public class BehaviorTest extends BehaviortestMocks {
    Behavior instance;
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
	instance = new Behavior();
	System.out.print("BehaviorTest test: ");
	instance.add(_actionMock);
	instance.add(_conditionMock);
	instance.add(_behaviorMock);
    }

    @After
    public void tearDown() {
    }
    /**
     * Test of Execute method, of class Behavior.
     */
    @Test
    public void testExecuteHappyPath() {
	System.out.println("Execute happy path");
	instance.execute();
	assertTrue(_actionMock.executed);
    }
    
    /**
     * Test of Execute method, of class Behavior.
     * The flexiblity of the pattern depends a lot on execution without conditions.
     * Thats why it has its own test
     */
    @Test
    public void testExecuteHappyPath_withoutConditions() {
	System.out.println("Execute withoudConditions happy path");
	instance.remove(_conditionMock);
	instance.execute();
	assertTrue(_actionMock.executed);
    }
    /**
     * Test of Execute method, of class Behavior.
     */
    @Test
    public void testExecuteHappyPathNot() {
	System.out.println("Execute not happy path");
	_conditionMock.suficiency = false;
	instance.execute();
	assertFalse(_actionMock.executed);
    }

    /**
     * Test of isSufficient method, of class Behavior.
     */
    @Test
    public void testIsSufficient() {
	System.out.println("isSufficient happy path");
	assertTrue(instance.isSufficient());
    }
    /**
     * Test of isSufficient method, of class Behavior.
     */
    @Test
    public void testIsSufficientNot() {
	System.out.println("isSufficient not happy path");
	_conditionMock.suficiency = false;
	assertFalse(instance.isSufficient());
    }
    
        /**
     * Test of isSufficient method, of class Behavior.
     */
    @Test
    public void testIsSubBehaviorExecuted() {
	System.out.println("IsSubBehaviorExecuted happy path");
	_conditionMock.suficiency = true;
	instance.execute();
	assertTrue(_behaviorMock._isExecuted);
    }
    
    /**
     * Test of behavior executiond, of class Behavior.
     */
    @Test
    public void testIsSubBehaviorExecutedNot() {
	System.out.println("IsSubBehaviorExecuted not happy path");
	_conditionMock.suficiency = false;
	instance.execute();
	assertFalse(_behaviorMock._isExecuted);
    }

}