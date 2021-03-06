/*
 * SyntaxException.java
 *
 * Created on May 29, 2006, 3:19 PM
 */

package lambdacalc.logic;

/**
 * This class is thrown by the ExpressionParser and TypeParser
 * when they encounter a syntax error in the input.
 * The 'position' argument may be -1 if no position is relevant,
 * otherwise the character index at the point the problem occurred.
 */
public class SyntaxException extends Exception {
    private int position;
    
    /**
     * Constructs a SyntaxException with the given message for
     * a problem occurring at the given position in the string
     * being parsed.
     */
    public SyntaxException(String message, int position) {
        super(message + ". Pos: " + position);
        this.position = position;
    }
    
    /**
     * Gets the character position in which the syntax
     * error occurred.
     */
    public int getPosition() {
        return position;
    }
}
