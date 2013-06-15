package Test.World.Behaviour.Decorator;

import Test.World.BehaviortestMocks;
import World.Behaviour.Behavior;
import World.Behaviour.Decorator.Inverse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class InverseTest extends BehaviortestMocks{
    
    private Inverse _instance;

    public InverseTest() {
    }

    @Before
    public void setUp() {
	System.out.print("InverseTest test: ");
	_instance = new Inverse(_conditionMock);
    }

    @Test
    public void testIsSufficient() {
	_conditionMock.suficiency = true;
	assertFalse(_instance.isSufficient());
    }
    
    @Test
    public void testIsSufficientBehavior() {
	_instance = new Inverse(new Behavior(_conditionMock));
	_conditionMock.suficiency = true;
	assertFalse(_instance.isSufficient());
    }

}