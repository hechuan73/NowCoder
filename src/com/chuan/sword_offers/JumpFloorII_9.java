package com.chuan.sword_offers;

/**
 * @author hechuan
 */
public class JumpFloorII_9 {

    /**
     * f(n) = f(n-1) + f(n-2) ... + f(1).
     * f(n-1) = f(n-2) + f(n-3) ... + f(1).
     *
     * => f(n) = 2 * f(n-1)
     * no that: jumping n floors is the same as f(1).
     *
     * @param target the target floor
     * @return the number of methods to jump to the target floor.
     */
    public int JumpFloorII(int target) {
        if (target <= 0) { return 0; }
        if (target == 1) { return 1; }
        if (target == 2) { return 2; }

        // start from floor two.
        int start = 2;
        for (int i = 3; i <= target; i++) {
            start = 2*start;
        }

        return start;
    }
}
