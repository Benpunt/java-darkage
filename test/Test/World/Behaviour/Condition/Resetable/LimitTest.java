package Test.World.Behaviour.Condition.Resetable;

import Test.World.BehaviortestMocks;
import World.Behaviour.Condition.Resetable.Limit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author jappie
 */
public class LimitTest extends BehaviortestMocks {
    private static final int 
	    START = 0,
	    LIMIT = 10,
	    INCREMENT = 1;
    private Limit _instance;

    public LimitTest() {
    }
    @Before
    public void setUp() {
	_instance = new Limit(START, LIMIT, INCREMENT);
	System.out.print("LimitTest test: ");
    }
    @Test 
    public void testIsSufficientHappyPath(){
	System.out.println("sufficient happypath");
	for(int i = START; i < LIMIT; i+= INCREMENT){
	    if(!_instance.isSufficient()){
		fail("to soon not sufficient");
	    }
	}	
    }
    @Test
    public void testIsSufficientHappyPath_isInsufficient() {
	this.testIsSufficientHappyPath();
	if(_instance.isSufficient()){
	    fail("should be insufficient");
	}
    }

    @Test
    public void testReset() {
	System.out.println("reset happypath");
	
	this.testIsSufficientHappyPath();
	_instance.reset();
	if(!_instance.isSufficient()){
	    fail("should be sufficient");
	}
    }

}