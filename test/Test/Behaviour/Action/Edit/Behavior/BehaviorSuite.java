package Test.Behaviour.Action.Edit.Behavior;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jappie
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Test.Behaviour.Action.Edit.Behavior.AddBehaviorTest.class,Test.Behaviour.Action.Edit.Behavior.RemoveBehaviorTest.class})
public class BehaviorSuite {

    @Before
    public void setUp() throws Exception {
    }

}