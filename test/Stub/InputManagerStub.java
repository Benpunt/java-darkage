/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stub;

import com.jme3.cursors.plugins.JmeCursor;
import com.jme3.input.InputManager;
import com.jme3.input.Joystick;
import com.jme3.input.RawInputListener;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.InputListener;
import com.jme3.input.controls.Trigger;
import com.jme3.input.event.InputEvent;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import com.jme3.math.Vector2f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Does absolutly nothing. where needed it may record an event.
 * for example my code uses a method from the 'real' input manager. Then this class
 * can record it & i can better unit test.
 * If i would use the 'real' input manager in that test, it would be an intergration test
 * @author jappie
 */
public class InputManagerStub extends InputManager {
    public String[] _keyNames;
    public InputListener _listener;
    public InputManagerStub(){
	super(new MouseInputStub(), new KeyInputStub(), null, null);
    }
    @Override
    public void beginInput() {
    }

    @Override
    public void endInput() {
    }

    @Override
    public void onJoyAxisEvent(JoyAxisEvent evt) {
    }

    @Override
    public void onJoyButtonEvent(JoyButtonEvent evt) {
    }

    @Override
    public void setMouseCursor(JmeCursor jmeCursor) {
    }

    @Override
    public void onMouseMotionEvent(MouseMotionEvent evt) {
    }

    @Override
    public void onMouseButtonEvent(MouseButtonEvent evt) {
    }

    @Override
    public void simulateEvent( InputEvent evt ) {
    }

    @Override
    public void onKeyEvent(KeyInputEvent evt) {
    }

    @Override
    public void setAxisDeadZone(float deadZone) {
    }

    @Override
    public float getAxisDeadZone() {
	throw new NotImplementedException();
    }

    @Override
    public void addListener(InputListener listener, String... mappingNames) {
	_listener = listener;
	_keyNames = mappingNames;
    }
    @Override
    public void removeListener(InputListener listener) {
    }

    @Override
    public void addMapping(String mappingName, Trigger... triggers) {
    }

    @Override
    public boolean hasMapping(String mappingName) {
	
	throw new NotImplementedException();
    }
    @Override
    public void deleteMapping(String mappingName) {
    }

    @Override
    public void deleteTrigger(String mappingName, Trigger trigger) {
    }
    @Override
    public void clearMappings() {
    }

    @Override
    public void reset() {
    }
    @Override
    public boolean isCursorVisible() {
	throw new NotImplementedException();
    }

    @Override
    public void setCursorVisible(boolean visible) {
    }

    @Override
    public Vector2f getCursorPosition() {
	throw new NotImplementedException();
    }

    @Override
    public Joystick[] getJoysticks() {
	throw new NotImplementedException();
    }
    @Override
    public void addRawInputListener(RawInputListener listener) {
    }

    @Override
    public void removeRawInputListener(RawInputListener listener) {
    }
    @Override
    public void clearRawInputListeners() {
    }

    @Override
    public void setSimulateMouse(boolean value) {
    }
    @Override
    public boolean getSimulateMouse() {
	throw new NotImplementedException();
    }
    @Override
    public void setSimulateKeyboard(boolean value) {
    }

    @Override
    public void update(float tpf) {
    }

    @Override
    public void onTouchEventQueued(TouchEvent evt) {
    }

    @Override
    public void onTouchEvent(TouchEvent evt) {
    }
}
