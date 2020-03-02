package sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class ContinuousSequenceEqaulToTarget_41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int low = 1, high = 2;
        int tmp;
        ArrayList<Integer> nums;
        while (high > low) {
            // sum of the arithmetic progression.
            tmp = (low + high) * (high-low+1) / 2;
            if (tmp == sum) {
                nums = new ArrayList<>();
                for (int i = low; i <= high; i++) { nums.add(i); }
                res.add(nums);
                low++;
            }
            else if (tmp < sum) { high++; }
            else { low++; }
        }

        return res;
    }
}
