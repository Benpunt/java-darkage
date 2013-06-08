/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.World.Behaviour;

import Mock.Behaviour.ActionMock;
import Mock.Behaviour.BehaviorMock;
import Mock.Behaviour.ConditionMock;
import org.junit.Before;

/**
 *
 * @author jappie
 */
public class BehaviortestMocks {
    public BehaviorMock _behaviorMock;
    public ActionMock _actionMock;
    public ConditionMock _conditionMock;
    public BehaviortestMocks(){
	
    }
    @Before
    public void initMocks() {
	_behaviorMock = new BehaviorMock();
	_actionMock = new ActionMock();
	_conditionMock = new ConditionMock();
    }
}
