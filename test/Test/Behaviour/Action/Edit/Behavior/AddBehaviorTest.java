package Test.Behaviour.Action.Edit.Behavior;

import Behaviour.Action.Edit.Behavior.AddBehavior;
import Mock.BehaviorMock;
import Test.Behaviour.BehaviortestMocks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class AddBehaviorTest  extends BehaviortestMocks{

    public AddBehaviorTest() {
    }

    @Before
    public void setUp() {
	System.out.print("AddBehaviorTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	AddBehavior instance = new AddBehavior(_behaviorMock, _behaviorMock);
	instance.execute();
	BehaviorMock mock = new BehaviorMock();
	Assert.assertEquals(mock, _behaviorMock._addedBehavior);
    }

}