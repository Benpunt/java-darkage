/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Scene;

import com.jme3.bullet.objects.PhysicsRigidBody;

/**
 *
 * @author jappie
 */
public interface IPhysicalBody extends IPresence{

    /**
     * @return the _shape
     */
    PhysicsRigidBody getPhysicsBody();

    /**
     * @param shape the _shape to set
     */
    void setPhysicsBody(PhysicsRigidBody shape);
    
}
