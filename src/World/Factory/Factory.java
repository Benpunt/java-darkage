/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This factory can create anaything with a default constructor and public constructor acces.
 * However if the Creates template is not simarly to the given class template it will fail.
 * @author jappie
 */
public class Factory<Abstract> implements IFactory<Abstract>{
    private static final String INSTANTATION = " could not be initilized posibilities: \n" +
" the class object represents an abstract class, an interface,\n" +
" an array class, a primitive type, or {@code void} the class has no nullary constructor\n",
	    ILLEGAL_ACCES = "could not acces the constructor of: ";

    private Class _implementation;
    public Factory(Class implementation){
	
	_implementation = implementation;
    }

    public Abstract create() {
	Logger.getLogger("Factory").log(Level.FINER, "Used generic factory to create a: {0}", _implementation.getName());
	try {
	    return (Abstract) _implementation.newInstance();
	} catch (InstantiationException ex) {
	    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, _implementation.getName()+INSTANTATION, ex);
	} catch (IllegalAccessException ex) {
	    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, ILLEGAL_ACCES + _implementation.getName(), ex);
	}
	// the aplication has to crash now, otherwise intracable bugs could apear.
	throw new IllegalArgumentException("Could not create the disered class");
    }

    /**
     * @param template the _template to set
     */
    public void setImplementation(Class implementation) {
	this._implementation = implementation;
    }
    
}
