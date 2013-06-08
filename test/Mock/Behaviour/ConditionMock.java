/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock.Behaviour;

import Behaviour.Condition.ICondition;

/**
 *
 * @author jappie
 */
public class ConditionMock extends ValidationMock implements ICondition{
    public boolean suficiency = true;
    public boolean isSufficient() {
	return suficiency;
    }
    
    @Override
    public boolean equals(Object to){
	return (to instanceof ConditionMock);
    }

    @Override
    public int hashCode() {
	return 1;
    }
    
}
