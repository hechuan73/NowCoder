package sword_offers;

/**
 * @author hechuan
 */
public class ConstructProductArray_50 {

    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        if (A.length > 0) {
            res[0] = 1;

            for (int i = 1; i < A.length; i++) {
                res[i] = res[i-1] * A[i-1];
            }

            int tmp = 1;
            for (int i = A.length - 2; i >= 0; i--) {
                tmp *= A[i+1];
                res[i] *= tmp;
            }
        }

        return res;
    }
}
