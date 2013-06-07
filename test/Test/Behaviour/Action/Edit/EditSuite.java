package Test.Behaviour.Action.Edit;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jappie
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Test.Behaviour.Action.Edit.Condition.ConditionSuite.class,Test.Behaviour.Action.Edit.Behavior.BehaviorSuite.class,Test.Behaviour.Action.Edit.Action.ActionSuite.class})
public class EditSuite {

    @Before
    public void setUp() throws Exception {
    }

}