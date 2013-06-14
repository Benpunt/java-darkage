package Test.World.Behaviour.Action.Edit.Action;

import Test.World.BehaviortestMocks;
import World.Behaviour.Action.Edit.Action.ActionRemover;
import World.Behaviour.Action.Edit.Action.ActionRemover;
import World.Behaviour.Action.Edit.Action.RemoveAction;
import World.Behaviour.Action.Edit.Action.RemoveAction;
import World.Behaviour.Behavior;
import World.Behaviour.Decorator.ValidOnce;
import World.Behaviour.IBehavior;
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
	
	IBehavior expected = new ValidOnce(new Behavior());
	expected.add(new ActionRemover(_behaviorMock, _actionMock));
	Assert.assertEquals(expected, _behaviorMock._addedBehavior);
    }

}