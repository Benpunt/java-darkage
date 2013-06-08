package Test.Behaviour.Action.Edit.Action;

import Behaviour.Action.Edit.Action.ActionRemover;
import Behaviour.Action.Edit.Action.RemoveAction;
import Behaviour.Action.Edit.Invalidate;
import Behaviour.Behavior;
import Behaviour.IBehavior;
import Test.Behaviour.BehaviortestMocks;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jappie
 */
public class RemoveActionTest  extends BehaviortestMocks{

    public RemoveActionTest() {
    }

    @Before
    public void setUp() {
	System.out.print("RemoveActionTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	RemoveAction instance = new RemoveAction(_behaviorMock, _actionMock);
	instance.execute();
	
	IBehavior expected = new Behavior();
	expected.add(new ActionRemover(_behaviorMock, _actionMock));
	expected.add(new Invalidate(expected));
	Assert.assertEquals(expected, _behaviorMock._addedBehavior);
    }

}