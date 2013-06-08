/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import java.util.Iterator;

/**
 * Allows behaviors (aka actions conditions & behaviors). To commit suicide.
 * This is importend because a logical memory leak is created when they try to
 * edit themselfs, but can't remove the objects who perform the edditing.
 * @author jappie
 */
public interface IValid{
    /** 
     * how to remove a conditional action, trough invalidate!
     * you don't have to do anything with this but it solves te loop
     * action removal problem. (wich was a big logical memory leak).
     */
    void invalidate();
    
    boolean isValid();
    
    /**
     * contains the action to perform if somthing is invalid
     * @param what
     * @param executioner
     * @return isValid
     */
    boolean validAction(Iterator executioner);
    
    /**
     * prevents infinite hash loops when calling equals
     * @return 
     */
    boolean isHashComputed();
}
