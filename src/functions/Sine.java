package functions;

/**
 * The Sine class represents a function
 * which consists of another function inside
 * of the Sine function.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class Sine extends Function {

    /** The inner function */
    private Function f;

    /**
     * Creates a new Sine with a given inner function.
     *
     * @param f the inner function
     */
    public Sine(Function f) {
        this.f = f;
    }

    /**
     * Evaluates the Sine at a given value for the variable X.
     *
     * @param x the value for any variables
     * @return the evaluation of the sine (a double)
     */
    @Override
    public double evaluate(double x) {
        return Math.sin(f.evaluate(x));
    }

    /**
     * Creates a string to represent the Sine function.
     *
     * @return "sin( f )"
     */
    @Override
    public String toString() {
        return "sin( " + f + " )";
    }

    /**
     * Computes the derivative of sine.
     *
     * @return the value of the derivative (a Function)
     */
    @Override
    public Function derivative() {
        Function partOne = new Cosine(f);
        Function partTwo = f.derivative();
        return new Product(partOne, partTwo);
    }

    /**
     * Determines if the sine is constant by checking
     * if all the inner functions are constant.
     *
     * @return
     */
    @Override
    public boolean isConstant() {
        return f.isConstant();
    }

    /**
     *
     * @param a
     * @param b
     * @param trap
     * @return
     */
}
