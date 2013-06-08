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
public class TimesPerFrameHandler implements ITpfHandler {
    private float _tpf;

    public float getTimesPerFrame() {
	return _tpf;
    }

    public void setTimesPerFrame(float tpf) {
	_tpf = tpf;
    }
    
}
