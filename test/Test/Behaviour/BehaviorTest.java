package Test.Behaviour;

import Behaviour.Action.IAction;
import Behaviour.Behavior;
import Behaviour.Behavior;
import Behaviour.Condition.ICondition;
import Mock.Behaviour.ActionMock;
import Mock.Behaviour.ConditionMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
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
	Assert.assertTrue(_actionMock.executed);
    }
    /**
     * Test of Execute method, of class Behavior.
     */
    @Test
    public void testExecuteHappyPathNot() {
	System.out.println("Execute not happy path");
	_conditionMock.suficiency = false;
	instance.execute();
	Assert.assertFalse(_actionMock.executed);
    }

    /**
     * Test of isSufficient method, of class Behavior.
     */
    @Test
    public void testIsSufficient() {
	System.out.println("isSufficient happy path");
	Assert.assertTrue(instance.isSufficient());
    }
    /**
     * Test of isSufficient method, of class Behavior.
     */
    @Test
    public void testIsSufficientNot() {
	System.out.println("isSufficient not happy path");
	_conditionMock.suficiency = false;
	Assert.assertFalse(instance.isSufficient());
    }

}