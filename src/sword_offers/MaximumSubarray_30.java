package sword_offers;

/**
 * @author hechuan
 */
public class MaximumSubarray_30 {

    /**
     * =========================================================================================================
     * There are two solutions, the second one is more subtle, while the first one is faster in most situations.
     * =========================================================================================================
     *
     * Approach 1: Dynamic Programming
     *     The continuous subarray will end with its sum less than 0. So we record each subarray's sum and find the
     *     largest as the solution.
     *
     *   F(i) = max(F(i-1)+arr[i], arr[i])  => F(i) is the maximum sum of the subarray which ends at the index i.
     *   res = max(res, F(i))   => res is the maximum sum of all subarrays.
     *
     * Time complexity: O(n).
     *
     * @param array input array.
     * @return the sum of the continuous subarray (containing at least one number) which has the largest sum.
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * Approach 2: Divide and Conquer.
     *     Divide the array into two subarray, and find the largest sum in two part. Then begin with the mid element,
     *     extend towards the two ends of the subarray and record its sum. Compare the three value to get to largest one
     *     as the solution.
     * @param array input array.
     * @return the sum of the continuous subarray (containing at least one number) which has the largest sum.
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        return maxPart(array, 0, array.length - 1);
    }

    private static int maxPart(int[] nums, int left, int right) {
        if (left == right) { return  nums[left]; }
        int mid = (left + right) / 2;
        return Math.max(maxPart(nums, left, mid),
                Math.max(maxMidExtend(nums, left, mid, right),
                        maxPart(nums, mid + 1, right)));
    }

    private static int maxMidExtend(int[] nums, int left, int mid, int right) {
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
