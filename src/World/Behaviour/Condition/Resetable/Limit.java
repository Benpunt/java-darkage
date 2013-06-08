/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Behaviour.Condition.Resetable;

/**
 * limits the execution cycle of somthing
 * @author jappie
 */
public class Limit extends ResetAble {
    private static final int 
	    DEFAULT_START = 0,
	    DEFAULT_LIMIT = 10,
	    DEFAULT_INCREMENT = 1;
    private double 
	    _start,
	    _counter,
	    _limit,
	    _increment;
    public Limit(){
	this(DEFAULT_START);
    }
    public Limit(double startValue){
	this(startValue, DEFAULT_LIMIT);
    }
    public Limit(double startValue, double limit){
	this(startValue, limit, DEFAULT_INCREMENT);
    }
    public Limit(double startValue, double limit, double increment){
	 _counter = _start = startValue;
	_limit = limit;
	_increment = increment;
    }

    public boolean isSufficient() {
	if(_counter < _limit){
	    _counter += _increment;
	    return true;
	}
	return false;
    }

    public void reset() {
	_counter = _start;
    }
    
    
}
