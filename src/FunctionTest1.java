import functions.*;

/**
 * Tests all methods except for Integral in Constant,
 * Variable, and Sum.
 *
 * @author Craig Gebo @ cjg2901@rit.edu
 */
public class FunctionTest1 {

    /**
     * Prints the function, computes the value at two points,
     * computes the derivative and prints whether it is constant or not.
     *
     * @param f a function
     */
    public static void test(Function f){
        System.out.println( "Function " + f );
        System.out.println( "Value at 0: " + f.evaluate( 0.0 ) );
        System.out.println( "Value at 10: " + f.evaluate( 10.0 ) );
        System.out.println( "Derivative: " + f.derivative() );
        System.out.println("isConstant: " + f.isConstant());
        System.out.println();
    }

    /**
     * Runs the test on various functions.
     *
     * @param args not used
     */
    public static void main( String[] args ) {
        if ( args.length != 0 ) {
            System.err.println( "FnTest0 takes no command line arguments." );
            System.exit( 1 );
        }
        Variable var = Variable.X;

        System.out.println("Test with one constant of value 0");
        Function f0 = new Constant( 0 );
        test(f0);

        System.out.println("Test with one constant");
        Function f1 = new Constant(9);
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
    }

}

