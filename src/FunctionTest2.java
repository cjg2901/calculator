import functions.*;

/**
 * Tests all methods for all classes
 * (Constant, Variable, Sum, Product, Cosine, Sine)
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class FunctionTest2 {

    /**
     * Prints the function, computes the value at two points,
     * computes the derivative, computes the integral over an interval
     * and prints whether it is constant or not.
     *
     * @param f a function
     */
    public static void test(Function f){
        System.out.println( "Function " + f );
        System.out.println( "Value at 0: " + f.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + f.derivative() );
        System.out.println( "Integral evaluated from 0 to 10: " + f.integral(0, 10, 1000000) );
        System.out.println( "isConstant: " + f.isConstant() );
        System.out.println();
    }

    /**
     * Runs the test on various functions.
     *
     * @param args not used
     */
    public static void main(String [] args) {
        if ( args.length != 0 ) {
            System.err.println( "FnTest0 takes no command line arguments." );
            System.exit( 1 );
        }
        Variable var = Variable.X;

        //Testing Sum, Constant, Variable
        System.out.println("Testing Constant, Variable and Sum...\n");

        System.out.println("Test with one constant of value 0");
        Function f0 = new Constant( 0 );
        test(f0);

        System.out.println("Test with one constant");
        Function f1 = new Constant( 9 );
        test(f1);

        System.out.println("Test with two constants");
        Function f2 = new Sum(new Constant( 9 ), new Constant(10));
        test(f2);

        System.out.println("Test with one variable");
        Function f3 = var;
        test(f3);

        System.out.println("Test with two variables");
        Function f4 = new Sum(var, var);
        test(f4);

        System.out.println("Test with one variable and one constant");
        Function f5 = new Sum(var, new Constant(10));
        test(f5);

        System.out.println("Test with two variables and two constants");
        Function f6 = new Sum( var, new Constant( 9 ), var, new Constant( 11 ) );
        test(f6);

        System.out.println("Test with three variables and three constants");
        Function f7 = new Sum(new Constant( 9 ), var, new Constant(100), var, var, new Constant(23));
        test(f7);

        //Testing Product
        System.out.println("Testing Product...\n");

        System.out.println("Test with one constants and one variable");
        Function g0 = new Product(new Constant(3), Variable.X);
        test(g0);

        System.out.println("Test with two constants");
        Function g1 = new Product(new Constant(3), new Constant(5));
        test(g1);

        System.out.println("Test with two variables");
        Function g2 = new Product(Variable.X, Variable.X);
        test(g2);

        System.out.println("Test with one constants and two variables");
        Function g3 = new Product(Variable.X, new Constant(5), Variable.X);
        test(g3);

        System.out.println("Test with two constants and two variables");
        Function g4 = new Product(Variable.X, new Constant(5), Variable.X, new Constant(3));
        test(g4);

        System.out.println("Test with two constants and three variables");
        Function g5 = new Product(Variable.X, new Constant(5), Variable.X, new Constant(3), Variable.X);
        test(g5);

        //Testing Cosine
        System.out.println("Testing Cosine...\n");

        System.out.println("Test with one constant");
        Function h0 = new Cosine(new Constant(2));
        test(h0);

        System.out.println("Test with one variable");
        Function h1 = new Cosine(Variable.X);
        test(h1);

        System.out.println("Test sum of one constant and one variable");
        Function h2 = new Cosine(new Sum (Variable.X, new Constant(.5)));
        test(h2);

        System.out.println("Test product of one constant and one variable");
        Function h3 = new Cosine(new Product (Variable.X, new Constant(.5)));
        test(h3);

        System.out.println("Test sum and product");
        Function h4 = new Cosine(new Sum(new Product(Variable.X, new Constant(0.5)), new Constant(2)));
        test(h4);

        //Testing Sine
        System.out.println("Testing Sine...\n");

        System.out.println("Test with one constant");
        Function h5 = new Sine(new Constant(2));
        test(h5);

        System.out.println("Test with one variable");
        Function h6 = new Sine(Variable.X);
        test(h6);

        System.out.println("Test sum of one constant and one variable");
        Function h7 = new Sine(new Sum (Variable.X, new Constant(.5)));
        test(h7);

        System.out.println("Test product of one constant and one variable");
        Function h8 = new Sine(new Product (Variable.X, new Constant(.5)));
        test(h8);

        System.out.println("Test sum and product");
        Function h9 = new Sine(new Sum(new Product(Variable.X, new Constant(0.5)), new Constant(2)));
        test(h9);

        //Complex Tests
        System.out.println("Complex Tests...\n");

        Function h10 = new Sum(
                new Product( Variable.X, Variable.X ),
                new Cosine( new Product( new Constant(2), Variable.X ) ),
                new Constant( 7 )
        );
        test(h10);

        Function h11 = new Product(
                new Product( Variable.X, Variable.X ),
                new Sine( new Product( new Constant(2), Variable.X ) ),
                new Constant( 7 )
        );
        test(h11);
    }
}
