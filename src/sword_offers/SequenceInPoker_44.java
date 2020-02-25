package sword_offers;

/**
 * @author hechuan
 */
public class SequenceInPoker_44 {

    /**
     * 扩展版：
     * 1. 允许包含重复的数字，即重复的牌;
     * 2. 允许牌的数量超过5。
     *
     * @param numbers input numbers
     * @return whether the number is continuous
     */
    public boolean isContinuous(int [] numbers) {
        int[] counter = new int[14];
        for (int num : numbers) { counter[num]++; }

        int count, require = 5-counter[0];
        for (int i = 1; i < counter.length-5; i ++) {
            if (counter[i] == 1) {
                count = 0;
                for (int j = 1; j < 5; j++) {
                    if (counter[i+j] >= 1) { count++; }
                    if (count >= require) { return true; }
                }

            }
        }

        return false;
    }
}
