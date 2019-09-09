package functions;

/**
 * The Constant class represents a function
 * which consists of a single constant numerical value.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class Constant extends Function {

    /** The value of the constant */
    private double value;

    /**
     * Creates a new constant with a given value.
     *
     * @param value the value of the constant
     */
    public Constant(double value) {
        this.value = value;
    }

    /**
     * Evaluates constant at a given value, for
     * a constant the given value does not matter.
     *
     * @param x not used
     * @return the value of the constant
     */
    @Override
    public double evaluate(double x) {
        return value;
    }

    /**
     * Returns the string which represents the value
     * of the constant.
     *
     * @return "#"
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Computes the derivative of a constant,
     * which is always 0.
     *
     * @return
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

    /**
     * Constants are constant, because they don't change
     * based on the value they are evaluated at.
     *
     * @return true
     */
    @Override
    public boolean isConstant() {
        return true;
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
        return (value * b) - (value * a);
    }
}
