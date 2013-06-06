/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Engine.State;

import GUI.Engine.Engine;
import com.jme3.app.Application;
import com.jme3.app.StatsView;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial.CullHint;

/**
 *
 * @author jappie
 */
public class Stats extends AbstractAppState {

    private Application app;
    protected StatsView statsView;
    protected boolean showSettings = true;
    private  boolean showFps = true;
    private  boolean showStats = true;
    
    protected Node guiNode;
    protected float secondCounter = 0.0f;
    protected int frameCounter = 0;
    protected BitmapText fpsText;
    protected BitmapFont guiFont;

    public Stats() {
    }    

    public Stats( Node guiNode, BitmapFont guiFont ) {
        this.guiNode = guiNode;
        this.guiFont = guiFont;
    }

    /**
     *  Called by SimpleApplication to provide an early font
     *  so that the fpsText can be created before init.  This
     *  is because several applications expect to directly access
     *  fpsText... unfortunately.
     */
    public void setFont( BitmapFont guiFont ) {
        this.guiFont = guiFont;
        this.fpsText = new BitmapText(guiFont, false);
    }

    public BitmapText getFpsText() {
        return fpsText;
    }
    
    public StatsView getStatsView() {
        return statsView;
    }

    public float getSecondCounter() {
        return secondCounter;
    }

    public void toggleStats() {
        setDisplayFps( !showFps );
        setDisplayStatView( !showStats );
    }

    public void setDisplayFps(boolean show) {
        showFps = show;
        if (fpsText != null) {
            fpsText.setCullHint(show ? CullHint.Never : CullHint.Always);
        }
    }

    public void setDisplayStatView(boolean show) {
        showStats = show;
        if (statsView != null ) {
            statsView.setEnabled(show);
            statsView.setCullHint(show ? CullHint.Never : CullHint.Always);
        }
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = app;
               
        if (app instanceof Engine) {
            Engine engine = (Engine)app;
            if (guiNode == null) {
		guiNode = engine.getGuiNode();
	    }
            if (guiFont == null ) {
		guiFont = engine.getGuiFont();
	    }
        } 
        
        if (guiNode == null) {
            throw new RuntimeException( "No guiNode specific and cannot be automatically determined." );
        } 
        
        if (guiFont == null) {
            guiFont = app.getAssetManager().loadFont("Interface/Fonts/Default.fnt");
        }
        
        loadFpsText();  
        loadStatsView();      
    }
            
    /**
     * Attaches FPS statistics to guiNode and displays it on the screen.
     *
     */
    public void loadFpsText() {
        if (fpsText == null) {
            fpsText = new BitmapText(guiFont, false);
        }
        
        fpsText.setLocalTranslation(0, fpsText.getLineHeight(), 0);
        fpsText.setText("Frames per second");
        fpsText.setCullHint(showFps ? CullHint.Never : CullHint.Always);
        guiNode.attachChild(fpsText);
    }

    /**
     * Attaches Statistics View to guiNode and displays it on the screen
     * above FPS statistics line.
     *
     */
    public void loadStatsView() {
        statsView = new StatsView("Statistics View", 
                                  app.getAssetManager(), 
                                  app.getRenderer().getStatistics());
        // move it up so it appears above fps text
        statsView.setLocalTranslation(0, fpsText.getLineHeight(), 0);
        statsView.setEnabled(showStats);
        statsView.setCullHint(showStats ? CullHint.Never : CullHint.Always);        
        guiNode.attachChild(statsView);
    }
        
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        
        if (enabled) {
            fpsText.setCullHint(showFps ? CullHint.Never : CullHint.Always);
            statsView.setEnabled(showStats);
            statsView.setCullHint(showStats ? CullHint.Never : CullHint.Always);        
        } else {
            fpsText.setCullHint(CullHint.Always);
            statsView.setEnabled(false);
            statsView.setCullHint(CullHint.Always);        
        }
    }
    
    @Override
    public void update(float tpf) {
        if (showFps) {
            secondCounter += app.getTimer().getTimePerFrame();
            frameCounter ++;
            if (secondCounter >= 1.0f) {
                int fps = (int) (frameCounter / secondCounter);
                fpsText.setText("Frames per second: " + fps);
                secondCounter = 0.0f;
                frameCounter = 0;
            }          
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        
        guiNode.detachChild(statsView);
        guiNode.detachChild(fpsText);
    }


}