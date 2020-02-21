package sword_offers;

public class MoreThanHalfTimesNumberInArray_28 {

    public int MoreThanHalfNum_Solution(int [] array) {
        // resultCount[0] -> number times; resultCount[1] -> number.
        int[] resultCount = new int[2];
        for (int value : array) {
            if (resultCount[0] == 0) {
                resultCount[0]++;
                resultCount[1] = value;
            } else {
                if (resultCount[1] == value) { resultCount[0]++; }
                else { resultCount[0]--; }
            }
        }

        if (resultCount[0] != 0) {
            // recheck to avoid that the length of the array is odd.
            if ((array.length & 1) == 1) {
                resultCount[0] = 0;
                for (int val : array) {
                    if (val == resultCount[1]) { resultCount[0]++; }
                }
                if (resultCount[0] * 2 < array.length) { return 0; }
            }
            return resultCount[1];
        }

        return 0;
    }
}
