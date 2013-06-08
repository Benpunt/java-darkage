package Test.World.Behaviour.Action.Edit.Condition;

import World.Behaviour.Action.Edit.Condition.RemoveCondition;
import Test.World.Behaviour.BehaviortestMocks;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class RemoveConditionTest extends BehaviortestMocks{

    public RemoveConditionTest() {
    }

    @Before
    public void setUp() {
	System.out.print("RemoveConditionTest test: ");
    }

    @Test
    public void testExecute() {
	System.out.println("Execute happy path.");
	RemoveCondition instance = new RemoveCondition(_behaviorMock, _conditionMock);
	instance.execute();
	assertEquals(_conditionMock, _behaviorMock._removedCondition);
    }

}