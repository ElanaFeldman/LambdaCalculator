/*
 * Multiplication.java
 *
 * Created on March 20, 2008, 7:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package lambdacalc.logic;

/**
 * Represents numeric multiplication, as in the denotation of the 'most'
 * generalized quantifier.
 */
public class Multiplication extends Binary {
    public static final char SYMBOL = '\u22C5'; // dot
    public static final char INPUT_SYMBOL = '*'; // asterisk
    public static final String LATEX_SYMBOL = "\\cdot"; // central dot
    
    public Multiplication(Expr left, Expr right) {
        super(left, right);
    }
    
    protected String toString(int mode) {
        if (mode == LATEX) {
            return getLeft().toString(mode) + LATEX_SYMBOL + getRight().toString(mode);
        } else { // mode == HTML || mode == TXT
            return getLeft().toString(mode) + SYMBOL + getRight().toString(mode);
        }
    }

    /**
     * Gets the operator precedence of this operator.
     * All values are documented in Expr, so don't change the value here
     * without changing it there.
     */
    public final int getOperatorPrecedence() {
        return 5;
    }
    
    protected Binary create(Expr left, Expr right) {
        return new Multiplication(left, right);
    }
    
    public Type getType() throws TypeEvaluationException {
        if (!getLeft().getType().equals(Type.N) || !getRight().getType().equals(Type.N))
            throw new TypeMismatchException("The types of the expressions on the left and right of the mulitiplication operator must be type i, but " + getLeft() + " is of type " + getLeft().getType() + " and " + getRight() + " is of type " + getRight().getType() + ".");
        return Type.N;
    }
    
    Multiplication(java.io.DataInputStream input) throws java.io.IOException {
        super(input);
    }

}
