package functions;

/**
 * The Variable class represents the function
 * consisting of a single variable X.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class Variable extends Function {

    /** Creates a new variable called X */
    public static final Variable X = new Variable();

    /**
     * The constructor is private because there
     * can only be one instance of a variable (X).
     */
    private Variable() {}

    /**
     * Returns the value (X) evaluated at.
     *
     * @param x the value which X represents
     * @return the value x
     */
    @Override
    public double evaluate(double x) {
        return x;
    }

    /**
     * Returns the string which represents a variable.
     *
     * @return "x"
     */
    @Override
    public String toString() {
        return "x";
    }

    /**
     * Computes the derivative of a variable,
     * which is always 1.
     *
     * @return a constant of value 1
     */
    @Override
    public Function derivative() {
        return new Constant(1);
    }

    /**
     * Variables are not constant, because they change
     * based on the value they are evaluated at.
     *
     * @return false
     */
    @Override
    public boolean isConstant() {
        return false;
    }

    /**
     * Calculates the integral of the function over a given interval,
     * by using direct integration.
     *
     * @param a the start of the interval
     * @param b the end of the interval
     * @param trap not used
     * @return the exact value of the integral over the interval
     */
    @Override
    public double integral(double a, double b, int trap) {
        return ((b * b) / 2) - ((a * a) / 2);
    }
}
