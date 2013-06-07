package Test.Behaviour.Action.Edit.Condition;

import Behaviour.Action.Edit.Condition.AddCondition;
import Test.Behaviour.BehaviortestMocks;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class AddConditionTest extends BehaviortestMocks{

    public AddConditionTest() {
    }

    @Before
    public void setUp() {
	System.out.print("AddConditionTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	AddCondition instance = new AddCondition(_behaviorMock, _conditionMock);
	instance.execute();
	assertEquals(_conditionMock, _behaviorMock._addedCondition);
    }

}