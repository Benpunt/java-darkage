package Test.Behaviour.Action.Edit.Action;

import Behaviour.Action.Edit.Action.ActionAddendummer;
import Test.Behaviour.BehaviortestMocks;
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
	ActionAddendummer target = new ActionAddendummer(_behaviorMock, _actionMock);
	target.execute();
	Assert.assertEquals(_actionMock, _behaviorMock._addedAction);
    }

}