package sword_offers;

/**
 * @author hechuan
 */
public class NumberOf1_11 {

    public int NumberOf1_1(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 0) { res++; }
            // '>>' is signed right shift, for negative number, it will add 1 in the left bit instead of 0.
            // '>>>' is unsigned right shift, no matter positive or negative number, add 0 in the left.
            n = (n >>> 1);
        }

        return res;
    }

    public int NumberOf1_2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            // n & (n-1) is remove the first '1' bit at the right of its binary representation.
            n &= (n-1);
        }

        return res;
    }

}
