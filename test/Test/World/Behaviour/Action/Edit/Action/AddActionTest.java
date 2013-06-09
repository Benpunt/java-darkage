package Test.World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.Edit.Action.ActionAddendummer;
import World.Behaviour.Action.Edit.Action.AddAction;
import World.Behaviour.Action.Edit.Invalidate;
import World.Behaviour.Behavior;
import World.Behaviour.IBehavior;
import Test.World.BehaviortestMocks;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class AddActionTest  extends BehaviortestMocks {

    public AddActionTest() {
    }

    @Before
    public void setUp() {
	System.out.print("AddActionTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	AddAction instance = new AddAction(_behaviorMock, _actionMock);
	instance.execute();
	
	// seems like intergration but only used for comparision of the result.
	// (which uses equals, but you have to draw the line somwhere).
	IBehavior expected = new Behavior();
	expected.add(new ActionAddendummer(_behaviorMock, _actionMock));
	expected.add(new Invalidate(expected));
	Assert.assertEquals(expected, _behaviorMock._addedBehavior);
	
    }

}