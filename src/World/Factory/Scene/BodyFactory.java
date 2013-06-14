/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory.Scene;

import World.Scene.Visual.Body;
import World.Scene.Visual.Shape.IShape;
import com.jme3.scene.Node;

/**
 * serves as a primitive play ground creator.
 * I will probably delete this later on but it will do for now
 *
 * @author jappie
 */
public class BodyFactory {
    private static final String[] CHARS = {"A", "B", "C", "D","E","F","G",
	"H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
	"Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
	"s","t","u","f","w","x","y","z","1","2","3","4","5","6","7","8","9"};
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
	double num =  100;
	for(int i = 0; i < num; i++){
	    IShape shape = _factory.createCube();
	    body.add(shape);
	    shape.getShape().move(3f*i, 0, 0);
	}
	
	_target.add(body);
	
	return body;
    }
    
    public Body createMap(){
	Body body = createBody();
	IShape shape = _factory.createMapCube();
	body.add(shape);
	shape.getShape().move(10f,0f, 0f);
	shape.getShape().scale(100f);
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
	String string = "";
	double rand = Math.random();
	for(int i = 0; i < rand * 10 +1; i++){
	    string += CHARS[(int)(Math.random()*10000)%CHARS.length];
	}
	return new Body(new Node(string));
    }
}
