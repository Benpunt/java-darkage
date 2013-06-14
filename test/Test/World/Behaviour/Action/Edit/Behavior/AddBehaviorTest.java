package Test.World.Behaviour.Action.Edit.Behavior;

import World.Behaviour.Action.Edit.Behavior.AddBehavior;
import Mock.Behaviour.BehaviorMock;
import Test.World.BehaviortestMocks;
import World.Behaviour.Action.Edit.Behavior.AddBehavior;
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