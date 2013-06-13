/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition;

/**
 * a condition that will not pass...
 * @author jappie
 */
public class False extends Condition{

    public boolean isSufficient() {
	return false;
    }
    
}
