package Test.Behaviour.Action.Edit.Action;

import Behaviour.Action.Edit.Action.ActionRemover;
import Test.Behaviour.BehaviortestMocks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class ActionRemoverTest  extends BehaviortestMocks{

    public ActionRemoverTest() {
    }

    @Before
    public void setUp() {
	System.out.print("ActionRemoverTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	ActionRemover instance = new ActionRemover(_behaviorMock, _actionMock);
	instance.execute();
	Assert.assertEquals(_actionMock, _behaviorMock._removedAction);
    }

}