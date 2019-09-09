package functions;

/**
 * The Sum class represents a function
 * which consists of "n-many" terms being added
 * together.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class Sum extends Function {

    /** the terms being added together */
    private Function[] terms;

    /**
     * Creates a new Sum with given terms to be added together.
     *
     * @param terms takes an array of Functions or
     *              a sequence of separate Function arguments
     */
    public Sum(Function... terms) {
        this.terms = combineConstants(terms);
    }

    /**
     * Combines all constants and removes a constant of zero
     * if it is not the only term left.
     *
     * @param terms an array of terms
     * @return an array of terms with constants combined
     */
    public Function[] combineConstants(Function[] terms) {
        double total = 0;
        int totalVars = 0;
        for (Function term : terms) {
            if (term.isConstant()) {
                total += term.evaluate(0);
            } else {
                totalVars++;
            }
        }
        if (total == 0 && totalVars != 0) {
            Function[] combined = new Function[totalVars];
            int i = 0;
            for (Function term : terms) {
                if (!term.isConstant()) {
                    combined[i] = term;
                    i++;
                }
            }
            return combined;
        } else {
            Function constant = new Constant(total);
            Function[] combined = new Function[totalVars + 1];
            int i = 0;
            for (Function term : terms) {
                if (!term.isConstant()) {
                    combined[i] = term;
                    i++;
                }
            }
            combined[i] = constant;
            return combined;
        }

    }

    /**
     * Evaluates the Sum at a given value for the variable X.
     *
     * @param x the value for any variables
     * @return the evaluation of the sum (a double)
     */
    @Override
    public double evaluate(double x) {
        double sum = 0;
        for (Function term : terms) {
            sum += term.evaluate(x);
        }
        return sum;
    }

    /**
     * Creates a string to represent the sum. Adds parentheses around the sum,
     * if there is more than 1 term.
     *
     * @return "term1 + term2 + term3 + ..."
     */
    @Override
    public String toString() {
        Function[] combined = combineConstants(terms);
        String sum = "";
        for (Function term:combined) {
            sum += term;
            sum += " + ";
        }
        if(combined.length == 1) {
            return sum.substring(0, sum.length() - 3);
        } else {
            return "( " + sum.substring(0, sum.length() - 3) + " )";
        }
    }

    /**
     * Computes the derivative of a sum.
     *
     * @return the value of the derivative (a Function)
     */
    @Override
    public Function derivative() {
        Function[] derivs = new Function[terms.length];
        int i = 0;
        for (Function term : terms) {
            derivs[i] = term.derivative();
            i++;
        }
        return new Sum(combineConstants(derivs));
    }

    /**
     * Determines if the sum is constant by checking
     * if all the inner functions are constant.
     *
     * @return true if all inner functions are constant,
     *         false otherwise
     */
    @Override
    public boolean isConstant() {
        boolean constant = true;
        for (Function term : terms) {
            constant = constant && term.isConstant();
        }
        return constant;
    }

    /**
     * Calculates the integral of the sum over a given interval.
     * By adding the integrals of each of the individual terms together.
     *
     * @param a the start of the interval
     * @param b the end of the interval
     * @param trap not used
     * @return the value of the integral (a double)
     */
    @Override
    public double integral(double a, double b, int trap) {
        double integral = 0;
        for (Function term : terms) {
            integral += term.integral(a, b, trap);
        }
        return integral;
    }
}
