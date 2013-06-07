/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import Scene.Shapes.Shape;
import Scene.Shapes.ShapeFactory;
import com.jme3.scene.Node;

/**
 * serves as a primitive play ground creator.
 * I will probably delete this later on but it will do for now
 *
 * @author jappie
 */
public class BodyFactory {
    private static final String SEED = "bladkjw029328wdfasf";
    private Body _target;
    private ShapeFactory _factory;
    public BodyFactory(Node rootNode, ShapeFactory factory){
	_target = createBody(rootNode);
	_factory = factory;
    }
    /**
     * creates a bunch of cubes and ataches them to the rootnode
     * @return 
     */
    public Body createCubes(){
	Body body = createBody();
	
	for(int i = 0; i < Math.random() * 50; i++){
	    Shape shape = _factory.createCube();
	    shape.getShape().move(3f, 0, 0);
	    body.add(shape);
	}
	
	_target.add(body);
	
	return body;
    }
    
    /**
     * calls the other create body with a null pointer.
     * the other create body will just create a node with
     * a default genareted name
     * @return 
     */
    private Body createBody(){
	/*
	 * hates the fact that java does not suport a defualt parameter value
	 * asignment like c++ c# & php do suport
	 */
	return createBody(null);
    }
    
    /**
     * creates a body, with or withoud a node
     * I realy don't care about those name, I will
     * keep track off them anyways
     * @param from
     * @return 
     */
    private Body createBody(Node from){
	if(from != null){
	    return new Body(from);
	}
	return new Body(new Node(Math.random() * 1000 + SEED));
    }
}
