/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package World.Factory;
/**
 * Generic factory interface... Prety useless for parametized creations with no real default
 * values or obtainable by enviorement (like times per frame)
 * A factory creates somthing (wow... took me quite a while to figure this one out)
 * @author jappie
 */
public interface IFactory<Creates> {
    Creates create();
}
