package Test.World.Behaviour.Action;

import Engine.Handler.BoolHandler;
import World.Behaviour.Action.SetFlag;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class SetFlagTest {
    private SetFlag _instance;
    private BoolHandler _target;

    public SetFlagTest() {
    }

    @Before
    public void setUp() {
	System.out.print("SetFlagTest test: ");
	_target = new BoolHandler(false);
	_instance = new SetFlag(_target, true);
    }

    @Test
    public void testExecute() {
	System.out.println("happy path to true");
	_instance.execute();
	assertTrue(_target.is()); // starting to talk like yoda
    }

}