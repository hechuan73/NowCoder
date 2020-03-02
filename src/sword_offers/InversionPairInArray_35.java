package sword_offers;

public class InversionPairInArray_35 {

    private long count = 0;

    /**
     * Solution with merge sort and counting in calculate.
     *
     * @param array input array
     * @return the inversion pairs
     */
    public int InversePairs(int [] array) {
        if (array.length == 0) { return 0; }
        partition(array, 0, array.length-1);
        return (int) (count % 1000000007);
    }

    private void partition(int[] nums, int start, int end) {
        if (start >= end) { return; }
        int mid = ((end-start)>>1) + start;
        partition(nums, start, mid);
        partition(nums, mid+1, end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end-start+1];

        int i = start, j = mid+1, index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[index++] = nums[i++];
            }
            else {
                tmp[index++] = nums[j++];
                count += mid-i+1;
            }
        }

        while (i <= mid) { tmp[index++] = nums[i++]; }
        while (j <= end) { tmp[index++] = nums[j++]; }
        System.arraycopy(tmp, 0, nums, start, tmp.length);
    }
}
