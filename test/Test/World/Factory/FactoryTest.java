package Test.World.Factory;

import Mock.Behaviour.ConditionMock;
import Stub.AbstractStub;
import Test.World.BehaviortestMocks;
import World.Behaviour.Condition.ICondition;
import World.Behaviour.Decorator.BehaviorDecorator;
import World.Factory.Factory;
import World.Factory.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class FactoryTest extends BehaviortestMocks{
    
    Factory<ICondition> _instanceCondition;

    public FactoryTest() {
    }

    @Before
    public void setUp() {
	System.out.print("FactoryTest test: ");
	_instanceCondition = new Factory<ICondition>(ConditionMock.class);
    }

    @Test
    public void testCreateHappy() {
	System.out.println("Happy path create");
	ICondition conditionMock = _instanceCondition.create();
	assertEquals(conditionMock, new ConditionMock());
    }
    @Test
    public void testCreateCast() {
	System.out.println("cast test");
	_instanceCondition.setImplementation(String.class);
	try{
	    ICondition conditionMock = _instanceCondition.create();
	}catch(ClassCastException e){
	    return;
	}
	fail("Factory should not create a string when its type is ICondition");
    }
    @Test
    public void testCreateAbstract() {
	System.out.println(" abstracct creation");
	
	// disable logging because this test generates an ugle mesage in outputs, wich
	// future me may find anoying
	Logger.getGlobal().setLevel(Level.OFF);
	_instanceCondition.setImplementation(AbstractStub.class);
	
	Logger.getGlobal().setLevel(Level.ALL);
	try{
	    ICondition conditionMock = _instanceCondition.create();
	}catch(IllegalArgumentException e){
	    return;
	}
	fail("Factory should not create an abstract class, ever!");
    }

}
