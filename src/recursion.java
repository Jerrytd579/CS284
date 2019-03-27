public class recursion {

    public static double fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }

    public static double tfact(int n, double a) {
        if (n == 0) {
            return a;
        } else {
            return tfact(n-1, n*a);
        }
    }

    public static double fib(int n) {
        if(n<=1) {
            return 1;
        }

        else {
            return fib(n-1)+fib(n-2);
        }
    }


    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(tfact(-5, 1));
    }
}
