package Test.World.Behaviour.Condition.Collision;

import World.Behaviour.Condition.Collision.Collision;
import World.Scene.Visual.Shape.Cube;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class CollisionTest {

    public CollisionTest() {
    }

    @Before
    public void setUp() {
	System.out.print("CollisionTest test: ");
    }

    /**
     * got a lot of can't creat this object warnings so i decided, unit test for a simple 
     * call to the constructor.
     */
    @Test
    public void testConstruction() {
	BulletAppState state = new BulletAppState();
	state.startPhysics();
	Collision c = new Collision(state.getPhysicsSpace(), 
		new Geometry("testBox", new Box(Vector3f.ZERO, 1, 1, 1))
		);
    }

}