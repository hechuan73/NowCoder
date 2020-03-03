package sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class MinimumValueConsistOfArrayElements_32 {

    /**
     *
     * 1. 将数据放进list。
     * 2. 对list的数据进行排序，按照将a和b转为string后若 a＋b < b+a 则a排在在前的规则排序,
     * 3. 读取数据组成string
     *
     * @param numbers input array
     * @return the string of minimum number
     */
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num : numbers) { nums.add(num); }

        nums.sort((a, b) -> (a + "" + b).compareTo(b + "" + a));

        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) { sb.append(num); }
        return sb.toString();
    }
}
