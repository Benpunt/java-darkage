package Test.World.Behaviour.Action.Edit.Action;

import World.Behaviour.Action.Edit.Action.ActionAddendummer;
import Test.World.BehaviortestMocks;
import World.Behaviour.Action.Edit.Action.ActionAddendummer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jappie
 */
public class ActionAddendummerTest extends BehaviortestMocks{

    public ActionAddendummerTest() {
    }

    @Before
    public void setUp() {
	
	System.out.print("ActionAddendummerTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	ActionAddendummer instance = new ActionAddendummer(_behaviorMock, _actionMock);
	instance.execute();
	Assert.assertEquals(_actionMock, _behaviorMock._addedAction);
    }

}