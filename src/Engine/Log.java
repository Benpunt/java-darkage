/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jappie
 */
public class Log {
    private static final Logger LOGGER = Logger.getLogger("dark-age-outputed");
    private static final Level LOG_LEVEL = Level.ALL;
    
    static{
        LOGGER.setLevel(LOG_LEVEL);

        ConsoleHandler handler = new ConsoleHandler();
        // PUBLISH this level
        handler.setLevel(LOG_LEVEL);
        LOGGER.addHandler(handler);
    }
    
    // no initilization of this class allowed
    private Log(){
	
    }
    public static Logger get(){
	return LOGGER;
    }
    public static void write(Level severity, String message, Object ... params){
	LOGGER.log(severity, message, params);
    }
    
    public static void write(Level severity, String message){
	LOGGER.log(severity, message);
    }
    
    public static void write(String message){
	LOGGER.info(message);
    }
}
