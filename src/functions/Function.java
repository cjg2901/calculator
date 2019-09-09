package functions;

/**
 * Function is an abstract class which represents a generic
 * function. Using an abstract class allows for easier computations
 * between different functions and storage in arrays.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public abstract class Function {
    /**
     * Evaluates the function at a given value x.
     *
     * @param x the value to be plugged in for any variables
     * @return the result of the evaluation at x
     */
    public abstract double evaluate(double x);

    /**
     * Creates a string which represents the function.
     *
     * @return the string version of the function
     */
    public abstract String toString();

    /**
     * Calculates the first derivative of the function.
     *
     * @return the first derivative of the function
     */
    public abstract Function derivative();

    /**
     * Checks if a function is constant, either directly or
     * by checking if all of its inner functions are constant.
     *
     * @return true if the function is constant, false otherwise
     */
    public abstract boolean isConstant();

    /**
     * Calculates the integral of the function over a given interval, by
     * using the trapezoid rule.
     *
     * @param a the start of the interval
     * @param b the end of the interval
     * @param trap the number of trapezoids
     * @return the approximation of the integral over the interval
     */
    public double integral(double a, double b, int trap) {
        double step = (b - a) / trap;
        double total = 0.5 * (this.evaluate(a) + this.evaluate(b));
        for (int i = 0; i < trap; i++) {
            double x = a + step * i;
            total = total + this.evaluate(x);
        }
        return total * step;
    }
}
