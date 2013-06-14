/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Handler;

/**
 * records the times per frame so I can inject it int the behavior pattern
 * ITpf contains only the getter so it can't be overwritten
 * 
 * times per frame allows constant movement, rotation etc. acros the screen.
 * Even with slower pcs.
 * 
 * @author jappie
 */
public class FloatHandler implements IFloatHandler {
    private  static final float DEFAULT_VALUE = 0;
    private float _value = DEFAULT_VALUE;

    public float get() {
	return _value;
    }

    public void set(float value) {
	_value = value;
    }
    
}
