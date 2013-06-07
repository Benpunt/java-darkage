package Test.Behaviour.Action.Edit.Action;

import Behaviour.Action.Edit.Action.AddAction;
import Behaviour.Behavior;
import Behaviour.IBehavior;
import Test.Behaviour.BehaviortestMocks;
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
	
	IBehavior excpected = new Behavior();
	excpected.add(_actionMock);
	
	Assert.assertEquals(excpected, _behaviorMock._addedBehavior);
	
    }

}