package Test.World.Behaviour.Decorator;

import Test.World.BehaviortestMocks;
import World.Behaviour.Decorator.ValidOnce;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class ValidOnceTest  extends BehaviortestMocks{
    ValidOnce _instance;
    public ValidOnceTest() {
    }

    @Before
    public void setUp() {
	System.out.print("ValidOnceTest test: ");
	_instance = new ValidOnce(_behaviorMock);
    }

    @Test
    public void testIsValid() {
	_behaviorMock._isValid = true;
	assertTrue(_instance.isValid());
    }
    @Test
    public void testIsValidNot() {
	_behaviorMock._isValid = true;
	_behaviorMock._invalidateCalled = false;
	_behaviorMock._invalidateCallValue = true;
	_instance.isValid();
	assertTrue(_behaviorMock._invalidateCalled);
    }

}