/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *  use this exception to indicate that somthing has to have somthing else
 *  but a parameter was set to null (which skipps type checking)
 * @author jappie
 */
public class CompositionException extends NullPointerException{
    private static final String MESSAGE_ADDENDUM = "can't exisits without a";
    
    public CompositionException (String subject, String missingComponent){
	super(subject + " " + MESSAGE_ADDENDUM + " " + missingComponent);
    }
    /**
     * Checks if the parameter is null, then a composition exeption is thrown
     * @param parameter The parameter to check
     * @param subject Which object class needs so desperatly that component
     * @param component The component needed
     */
    public static void Check(Object parameter, String subject, String component){
	if(parameter == null){
	    throw new CompositionException(subject, component);
	}
    }
}
