package Engine;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wraps arround the java.util.logging.Logger, just to save some typing time.
 * & it makes all the loging go trough here so sutting it down is easy
 * @author jappie
 */
public class Log {
    private static final Logger LOGGER = Logger.getLogger("dark-age-outputed");
    private static final Level LOG_LEVEL = Level.FINER;
    
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
    private static void write(Level severity, String message, Object ... params){
	LOGGER.log(severity, message, params);
    }
    
    private static void write(Level severity, String message){
	LOGGER.log(severity, message);
    }
    
    private static void write(String message){
	write(Level.INFO, message);
    }
    
    public static void debug(String message){
	write(Level.FINER, message);
    }
    
    public static void verbose(String message){
	write(Level.FINEST, message);
    }
    
    public static void write(String message, Object ... params){
	write(Level.INFO, message, params);
    }
    
    public static void debug(String message, Object ... params){
	write(Level.FINER, message, params);
    }
    
    public static void verbose(String message, Object ... params){
	write(Level.FINEST, message, params);
    }
}
