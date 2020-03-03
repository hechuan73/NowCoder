package sword_offers;

/**
 * @author hechuan
 */
public class RectangleCovering_10 {

    public int RectCover(int target) {
        if (target <= 0) { return 0; }
        if (target == 1) { return 1; }
        if (target == 2) { return 2; }

        int f1 = 1, f2 = 2;
        for (int i = 3; i <= target ; i++) {
            f2 += f1;
            f1 = f2-f1;
        }

        return f2;
    }
}
