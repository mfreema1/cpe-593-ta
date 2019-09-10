package algorithmic_analysis;

public class Main {

    public static void main(String[] args) {}

    /*
    Algorithmic complexity -- what is it?  It's a tool to tell us how fast
    an algorithm is in terms of its input.  This isn't important for
    small inputs to algorithms, however we don't really care about that --
    mainly because the problems that require really ingenuity typically
    operate at a very large scale. After all, they don't really pay people
    to solve trivial problems.

    We also most commonly deal with the worst case of algorithms, the Big O,
    just because it's good to know that we can't possibly do worse than that.
    It is also helpful to know the best case, though -- especially if it
    will dominate the majority of executions.  We call that the Big Omega.
    When we mix the two, we get the average case, or the Big Theta.
     */

    /*
    Take a look at the below snippet of code.  What is its complexity?
     */
    void functionOne() {
        System.out.println("Hello world!");
    }

    /*
    Should be fairly obvious that that was O(1).  Why?  Because we don't
    reference any input -- it always takes the same amount of time.  It
    could take 4 hours to print or 1 second -- still O(1).  Now try the
    below.
     */
    void functionTwo() {
        for(int i = 0; i < 1000000; i++) {
            System.out.println("Hello world!");
        }
    }

    /*
    Still O(1)!  Again, we did not reference the input on this at all.
    Try the next one.
     */
    void functionThree(int n) {
        for(int i = 0; i < n; i++) {
            System.out.println("Hello world!");
        }
    }

    /*
    Ahh, finally one that isn't O(1) -- this is O(n), and the reasoning
    should be fairly clear.  For every number from 1 to n, we do a constant
    unit of work -- so our work scales directly with n, meaning that we
    are O(n).
     */

    /*
    What happens when we put things next to each other?
     */
    void functionFour(int n) {
        for(int i = 0; i < 1000000; i++) {
            System.out.println("Hello world!");
        }
        for(int i = 0; i < n; i++) {
            System.out.println("Hello world!");
        }
    }

    /*
    That was O(1) + O(n), but not really.  The first section is O(1) and
    the second is O(n).  We only care about the highest term, mainly because
    at large inputs, it will dominate the runtime of the algorithm.

    So as you can see, when we place sequences next to each other, their
    runtimes add together, but the overall runtime of the algorithm
    will be dominated by one of them.
     */

    /*
    Now what happens when we start nesting runtimes?
     */
    void functionFive(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.println("Hello world!");
            }
        }
    }

    /*
    This would be O(n^2) or n squared.  When we nest runtimes, they
    multiply with each other.  So, we have O(n) * O(n) and get n squared.
     */

    /*
    Try this one, it's a little trickier.
     */
    void functionSix(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.println("Hello world!");
            }
        }
    }

    /*
    This is O(n^2).  If this seems unclear, picture what happens with j
    on the inside loop.

    0
    0 1
    0 1 2
    0 1 2 3
    0 1 2 3 4

    That is a triangle.  Why do we care?  Well O(n^2) could be represented
    by a square, each of side length n.  We know that the area for the triangle
    is half that of the square so it's O((n^2)/2) which is still O(n^2).
     */

    void functionSeven(int n) {
        for(int i = 0; i < n; i += 5) {
            System.out.println("Hello world!");
        }
    }

    /*
    Still O(n).  Why?  You're getting there 5 times as fast via the increment,
    so that's O(1/5(n)), which becomes O(n).

    As a general rule, constant additions for the increment tend not to
    change the runtime.
     */

    void functionEight(int n) {
        for(int i = 1; i < n; i *= 2) {
            System.out.println("Hello world!");
        }
    }

    /*
    Trickier.  Think of the number on the increment as it races upward.

    1
    2
    4
    8
    16

    This is clearly powers of two.  If you want to know how many powers of a
    number it will take to get somewhere, you take the log of that number.
    So, this is actually log2(n), or generally log(n).
     */
}