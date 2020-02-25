package sword_offers;

/**
 * @author hechuan
 */
public class FindDuplicationInArray_49 {

    /**
     * Simple method with extra spaces.
     *
     * @param numbers     input array
     * @param length      length of the array
     * @param duplication duplication[0] is duplicate number
     * @return whether it is duplicate
     */
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        int[] counter = new int[length];
        for (int i = 0; i < length; i++) {
            if (counter[numbers[i]]++ > 0) {
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }

    /**
     * Optimised method without extra spaces.
     *
     * @param numbers     input array
     * @param length      length of the array
     * @param duplication duplication[0] is duplicate number
     * @return whether it is duplicate
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index < 0) { index = -index; }

            if (numbers[index] < 0) {
                duplication[0] = index;
                return true;
            }

            numbers[index] = -numbers[index];
        }
        return false;
    }
}
