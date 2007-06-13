/*
 * AssignmentFunction.java
 *
 * Created on June 7, 2007, 8:47 PM
 *
 */

package lambdacalc.lf;

import java.util.HashMap;
import lambdacalc.logic.GApp;
import lambdacalc.logic.Var;

/**
 * A function from 
 * @author champoll
 */
public class AssignmentFunction extends HashMap {
    
    /** Creates a new instance of AssignmentFunction */
    public AssignmentFunction() {
    }
    
    public AssignmentFunction put(int key, Var value) {
        return (AssignmentFunction) put(new GApp(key), value);
    }
    
    public Object put(Integer key, Var value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        return super.put(new GApp((Integer) key), value);
    }
    
    public Object put(GApp key, Var value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        return super.put(key, value);
    }
    public Object put(Object key, Object value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        if (!(key instanceof Integer) && !(key instanceof GApp)) throw new IllegalArgumentException();
        if (!(value instanceof Var)) throw new IllegalArgumentException();
        
        if (key instanceof Integer) {
            return this.put((Integer) key, (Var) value);
        } else if (key instanceof GApp) {
            return this.put((GApp) key, (Var) value);
        } else { // can't get here
            throw new RuntimeException(); 
        }
    }
    
    public boolean containsKey(Object key) {
        if (key instanceof Integer) {
            return super.containsKey(new GApp((Integer) key));
        } else {
            return super.containsKey(key);
        }
    }
    
    public boolean containsKey(int key) {
        return super.containsKey(new GApp(key));
    }        
    
    public Object get(Object key) {
        if (key instanceof Integer) {
            return super.get(new GApp((Integer) key));
        } else {
            return super.get(key);
        }
    }
    
    public Object get(int key) {
        return super.get(new GApp(key));
    }
    
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }
    
    public String toString() {
        return "Not yet implemented";
    }
    
}