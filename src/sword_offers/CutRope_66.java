package sword_offers;

/**
 * @author hechuan
 */
public class CutRope_66 {

    /**
     * Simple mathematical solution.
     *
     * Regularity:
     * Many solutions were referring to factors of 2 and 3. But why these two magic numbers? Why other factors do not
     * work? Let's study the math behind it.
     *
     * For convenience, say n is sufficiently large and can be broken into any smaller real positive numbers. We now try
     * to calculate which real number generates the largest product.
     *
     * Assume we break n into (n / x) x's, then the product will be x^(n/x), and we want to maximize it. Taking its
     * derivative gives us n * x^(n/x-2) * (1 - ln(x)). The derivative is positive when 0 < x < e, and equal to 0 when
     * x = e, then becomes negative when x > e, which indicates that the product increases as x increases, then reaches
     * its maximum when x = e, then starts dropping.
     *
     * This reveals the fact that if n is sufficiently large and we are allowed to break n into real numbers, the best
     * idea is to break it into nearly all e's. On the other hand, if n is sufficiently large and we can only break n
     * into integers, we should choose integers that are closer to e. The only potential candidates are 2 and 3 since
     * 2 < e < 3, but we will generally prefer 3 to 2. Why? Of course, one can prove it based on the formula above, but
     * there is a more natural way shown as follows.
     *
     * 6 = 2 + 2 + 2 = 3 + 3. But 2 * 2 * 2 < 3 * 3. Therefore, if there are three 2's in the decomposition, we can
     * replace them by two 3's to gain a larger product.
     *
     * All the analysis above assumes n is significantly large. When n is small (say n <= 10), it may contain flaws.
     * For instance, when n = 4, we have 2 * 2 > 3 * 1. To fix it, we keep breaking n into 3's until n gets smaller than
     * 10, then solve the problem by brute-force.
     *
     * Another perspective:
     * If an optimal product contains a factor f >= 4, then you can replace it with factors 2 and f-2 without losing
     * optimality, as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or equal to 4, meaning you only need
     * factors 1, 2 and 3 (and 1 is of course wasteful and you'd only use it for n=2 and n=3, where it's needed).
     *
     * For the rest I agree, 3*3 is simply better than 2*2*2, so you'd never use 2 more than twice.
     *
     * @param target input number
     * @return the maximum product
     */
    public int cutRope(int target) {
        // must cut to several segments.
        if (target == 2) { return 1;}
        // must cut to several segments.
        if (target == 3) { return 2;}

        int remainder = target % 3;
        int quotient = target / 3;

        if (remainder == 0) { return (int) Math.pow(3, quotient); }
        else if (remainder == 1) { return (int) (2*2*Math.pow(3, quotient-1)); }
        else { return (int) (2*Math.pow(3, quotient)); }
    }
}
