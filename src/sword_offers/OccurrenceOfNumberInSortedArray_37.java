package sword_offers;

/**
 * @author hechuan
 */
public class OccurrenceOfNumberInSortedArray_37 {

    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) { return 0; }
        if (array.length == 1) { return array[0] == k ? 1 : 0; }
        int low = 0, high = array.length-1, mid = 0;
        while (low < high) {
            mid = ((high-low) >> 1) + low;
            if (array[mid] == k) { break; }
            else if (array[mid] > k) { high = mid-1; }
            else { low = mid+1; }
        }

        int res = 0;
        if (array[mid] == k) {
            int i = mid;
            for (; i >= 0; i--) { if (array[i] != k) { break; } }
            res += mid-i;

            i = mid+1;
            for (; i < array.length; i++) { if (array[i] != k) { break; } }
            res += i-(mid+1);
        }

        return res;
    }
}
