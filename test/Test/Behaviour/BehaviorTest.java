package Test.Behaviour;

import Behaviour.Action.IAction;
import Behaviour.Behavior;
import Behaviour.Behavior;
import Behaviour.Condition.ICondition;
import Mock.ActionMock;
import Mock.ConditionMock;
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
public class BehaviorTest {
    Behavior instance;
    ActionMock actionMock;
    ConditionMock conditionMock;
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
	actionMock = new ActionMock();
	conditionMock = new ConditionMock();
	instance.add(actionMock);
	instance.add(conditionMock);
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
	Assert.assertTrue(actionMock.executed);
    }
    /**
     * Test of Execute method, of class Behavior.
     */
    @Test
    public void testExecuteHappyPathNot() {
	System.out.println("Execute not happy path");
	conditionMock.suficiency = false;
	instance.execute();
	Assert.assertFalse(actionMock.executed);
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
	conditionMock.suficiency = false;
	Assert.assertFalse(instance.isSufficient());
    }

}