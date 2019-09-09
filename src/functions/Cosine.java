package functions;

/**
 * The Cosine class represents a function
 * which consists of another function inside
 * of the Cosine function.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class Cosine extends Function {

    /** The inner function */
    private Function f;

    /**
     * Creates a new Cosine with a given inner function.
     *
     * @param f the inner function
     */
    public Cosine(Function f) {
        this.f = f;
    }

    /**
     * Evaluates the Cosine at a given value for the variable X.
     *
     * @param x the value for any variables
     * @return the evaluation of the cosine (a double)
     */
    @Override
    public double evaluate(double x) {
        return Math.cos(f.evaluate(x));
    }

    /**
     * Creates a string to represent the Cosine function.
     *
     * @return "cos( f )"
     */
    @Override
    public String toString() {
        return "cos( " + f + " )";
    }

    /**
     * Computes the derivative of cosine.
     *
     * @return the value of the derivative (a Function)
     */
    @Override
    public Function derivative() {
        Function partOne = new Product(new Constant(-1), new Sine(f));
        Function partTwo = f.derivative();
        return new Product(partOne, partTwo);
    }

    /**
     * Determines if the cosine is constant by checking
     * if all the inner functions are constant.
     *
     * @return
     */
    @Override
    public boolean isConstant() {
        return f.isConstant();
    }
}
