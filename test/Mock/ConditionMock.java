/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mock;

import Behaviour.Condition.ICondition;

/**
 *
 * @author jappie
 */
public class ConditionMock implements ICondition{
    public boolean suficiency = true;
    public boolean isSufficient() {
	return suficiency;
    }
    
}
