package Test.World.Behaviour.Action.Move;

import Engine.Handler.FloatHandler;
import Mock.Behaviour.MoveableMock;
import World.Behaviour.Action.Move.Move;
import com.jme3.math.Vector3f;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class MoveTest {
    
    private Move _instance;
    private MoveableMock _moveMock;
    private FloatHandler _floatHandler;
    private Vector3f _vector,
	    _expected = new Vector3f(12,24,48);

    public MoveTest() {
    }

    @Before
    public void setUp() {
	System.out.print("MoveTest test: ");
	_floatHandler = new FloatHandler();
	_floatHandler.set(0.5f);
	_instance = new Move(
	    _moveMock = new MoveableMock(), 
	    _vector = new Vector3f(8, 16, 32),
	    _floatHandler
	);
    }

    @Test
    public void testExecute() {
	Vector3f movement = new Vector3f();
	_instance.execute();
	movement.addLocal(_moveMock._location);
	_instance.execute();
	movement.addLocal(_moveMock._location);
	_instance.execute();
	movement.addLocal(_moveMock._location);
	Assert.assertEquals(_expected, movement);
    }

}