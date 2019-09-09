package functions;

/**
 * The Product class represents a function
 * consisting of "n-many" terms being
 * multiplied together.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class Product extends Function {

    /** the terms being multiplied together */
    private Function[] terms;

    /**
     * Creates a new Product with given terms to be multiplied together
     *
     * @param terms takes an array of Functions or
     *              a sequence of separate Function arguments
     */
    public Product(Function... terms) {
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
        double total = 1;
        int totalVars = 0;
        for (Function term : terms) {
            if (term.isConstant()) {
                if (term.evaluate(0) == 0) {
                    Function[] zero = new Function[1];
                    zero[0] = new Constant(0);
                    return zero;
                }
                total *= term.evaluate(0);
            } else {
                totalVars++;
            }
        }
        if (total == 1 && totalVars != 0) {
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
     * Evaluates the Product at a given value for the variable X.
     *
     * @param x the value for any variables
     * @return the evaluation of the product (a double)
     */
    @Override
    public double evaluate(double x) {
        double product = 1;
        for (Function term : terms) {
            product *= term.evaluate(x);
        }
        return product;
    }

    /**
     * Creates a string to represent the product. Adds parentheses around the product,
     * if there is more than 1 term.
     *
     * @return "term1 + term2 + term3 + ..."
     */
    @Override
    public String toString() {
        Function[] combined = combineConstants(terms);
        String product = "";
        for (Function term : combined) {
            product += term;
            product += " * ";
        }
        if(combined.length == 1) {
            return product.substring(0, product.length() - 3);
        }
        return "( " + product.substring(0, product.length() - 3) + " )";
    }

    /**
     * Computes the derivative of a product.
     *
     * @return the value of the derivative (a Function)
     */
    @Override
    public Function derivative() {
        if (terms.length == 1) {
            return terms[0].derivative();
        }
        else if (terms.length == 2) {
            Function derivative = new Sum(new Product(terms[0].derivative(), terms[1]), new Product(terms[1].derivative(), terms[0]));
            return derivative;
        }
        else {
            Function [] derivativeTerms = new Function[terms.length];
            for (int i = 0; i < terms.length; i++) {
                Function[] multiDerivTerms = new Function[terms.length];
                for (int j = 0; j < terms.length; j++) {
                    if (i == j) {
                        multiDerivTerms[j] = terms[j].derivative();
                    } else {
                        multiDerivTerms[j] = terms[j];
                    }
                }
                derivativeTerms[i] = new Product(multiDerivTerms);
            }
            return new Sum(derivativeTerms);
        }
    }

    /**
     * Determines if the product is constant by checking
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
}
