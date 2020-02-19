package sword_offers;

/**
 * @author hechuan
 */
public class Power_12 {

    /**
     * Solution with iteration.
     *
     * @param base base number
     * @param exponent exponent number
     * @return the power
     */
    public double Power1(double base, int exponent) {
        double res = 1;
        boolean flag = exponent >= 0;
        if (!flag) { exponent = -exponent; }
        while (exponent > 0) {
            res *= base;
            exponent -= 1;
        }
        return flag ? res : 1/res;
    }

    /**
     * Solution with quick recursion.
     *
     * @param base base number
     * @param exponent exponent number
     * @return the power
     */
    public double Power2(double base, int exponent) {
        boolean flag = exponent < 0;
        if (flag) { exponent = -exponent; }
        double res = getPower(base, exponent);

        return flag ? 1/res : res;
    }

    private double getPower(double base, int exponent) {
        if (exponent == 0) { return 1; }
        if (exponent == 1) { return base; }

        // exponent >> 1: calculate half of the exponent.
        double res = getPower(base, exponent >> 1);
        res *= res;
        if ((exponent & 1) != 0) { res *= base; }

        return res;
    }
}
