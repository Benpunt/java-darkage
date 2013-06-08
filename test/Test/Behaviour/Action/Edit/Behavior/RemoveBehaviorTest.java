package Test.Behaviour.Action.Edit.Behavior;

import World.Behaviour.Action.Edit.Behavior.RemoveBehavior;
import Mock.Behaviour.BehaviorMock;
import Test.Behaviour.BehaviortestMocks;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class RemoveBehaviorTest  extends BehaviortestMocks{

    public RemoveBehaviorTest() {
    }

    @Before
    public void setUp() {
	System.out.print("RemoveBehaviorTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	RemoveBehavior instance = new RemoveBehavior(_behaviorMock, _behaviorMock);
	instance.execute();
	BehaviorMock mock = new BehaviorMock();
	assertEquals(mock, _behaviorMock._removedBehavior);
    }

}