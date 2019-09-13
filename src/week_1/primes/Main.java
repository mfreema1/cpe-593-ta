package week_1.primes;

public class Main {

    public static  void main(String[] args) {
        System.out.println(sieveOfEratosthenes(1000000));
        System.out.println(fermat(17, 5));
    }

    /*
    The Sieve of Eratosthenes.  For this, we will count the number of primes
    up to a certain number.
     */
    private static int sieveOfEratosthenes(int n) {
        //block special cases
        if (n <= 3) {
            return n - 1;
        }
        else {
            //make space for all numbers, assume them to be prime at first
            boolean[] numbers = new boolean[n];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = true;
            }

            //go through and clear all the evens from 4 to n
            for (int i = 4; i < n; i += 2) {
                numbers[i] = false;
            }

            /*
            go from 3 to n (only odds) and if the flag is still there, eliminate
            every other multiple from i^2 to n, jumping by 2i.  We do this
            because these are all odd numbers.  An odd number plus an odd number
            is always even, so half of the time, if we jump by i, we will hit an even
            number which cannot be prime.  Jumping by 2i avoids these checks.
             */
            int count = 1;
            for (int i = 3; i < n; i += 2) { //O(n) time
                if (numbers[i]) {
                    count++;
                    if (i < Math.sqrt(n)) {
                        for (int j = i * i; j < n; j += 2 * i) { //log(n) time
                            numbers[j] = false;
                        }
                    }
                }
            }
            return count;
        }
    }

    /*
    This prime-number detector is derived from the Little Theorem.  The Little
    Theorem states that:

    if a number p is prime, then a^(p-1)mod p == 1

    The inverse is not necessarily true though, meaning that if the Little Theorem
    holds, we don't necessarily know that the number is prime.

    However, with enough trials, we could make a reasonable guess that a number is
    prime.  This is hence a probabilistic function.
     */
    private static boolean fermat(int n, int trials) {
        //can't do 1 or p - 1
        if(trials + 2 > n) {
            throw new RuntimeException("Don't have enough trial candidates");
        }
        for(int i = 2; i <= trials; i++) {
            if(powermod(i, n - 1, n) != 1) {
                return false;
            }
        }
        return true;
    }

    /*
    A quick way to determine x^n mod m.  It runs in log(n) time.
     */
    private static int powermod(int x, int n, int m) {
        int product = 1;
        while(n > 0) {
            if(n % 2 != 0) {
                product *= x % m;
            }
            x = x * x % m;
            n /= 2;
        }
        return product;
    }
}
