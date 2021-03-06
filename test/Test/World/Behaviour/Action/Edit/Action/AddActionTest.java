package Test.World.Behaviour.Action.Edit.Action;

import Test.World.BehaviortestMocks;
import World.Behaviour.Action.Edit.Action.ActionAddendummer;
import World.Behaviour.Action.Edit.Action.ActionAddendummer;
import World.Behaviour.Action.Edit.Action.AddAction;
import World.Behaviour.Action.Edit.Action.AddAction;
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
	IBehavior expected = new ValidOnce(new Behavior());
	expected.add(new ActionAddendummer(_behaviorMock, _actionMock));
	
	Assert.assertEquals(expected, _behaviorMock._addedBehavior);
	
    }

}