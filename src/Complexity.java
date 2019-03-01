/**
 * Jerry Cheng
 * Worked with Jerry Chen
 *
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 2/13/2019
 *
 */

public class Complexity {

    // O(n^2)
    public static void method1(int n) {
        int z = 0;
        for(int x = 0; x <= n; x++) {
            for(int y = 0; y < n; y++) {
                System.out.println(z);
                z++;
            }
        }
    }

    // O(n^3)
    public static void method2(int n) {
        int a = 0;
        for(int x = 0; x <= n; x++) {
            for(int y = 0; y < n; y++) {
                for(int z = 0; z < n; z++) {
                    System.out.println(a);
                    a++;
                }
            }
        }
    }

    // O(log n)
    public static void method3(int n) {
        int a = 0;
        for(int j = 1; j<n; j*=2) {
            System.out.println(a);
            a++;
        }
    }

    // O(n log n)
    public static void method4(int n) {
        int a = 0;
        for(int i = 1; i<n; i++) {
            for(int j = 1; j<n; j*=2) {
                System.out.println(a);
                a++;
            }
        }
    }

    // O(log log n)
    public static void method5(int n) {
        int a = 0;
        for(int j = 1; j<n; j*=2) {
            for(int z = 1; z<n; z*=2) {
                System.out.println(a);
                a++;
            }
        }
    }
}
