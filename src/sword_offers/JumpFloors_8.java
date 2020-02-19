package sword_offers;

public class JumpFloors_8 {

    public int JumpFloor1(int target) {
        if (target <= 0) { return 0; }
        if (target == 1) { return 1; }
        if (target == 2) { return 2; }
        return JumpFloor1(target-1) + JumpFloor1(target-2);
    }

    public int JumpFloor2(int target) {
        if (target <= 0) { return 0; }
        if (target == 1) { return 1; }
        if (target == 2) { return 2; }
        int step1 = 1;
        int step2 = 2;

        for (int i = 3; i <= target; i++) {
            step2 += step1;
            step1 = step2-step1;
        }

        return step2;
    }

}
