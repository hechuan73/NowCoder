package sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class UglyNumber_33 {

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) { return index; }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        int val2, val3, val5, newNum = 0;
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {
            val2 = list.get(i2) * 2;
            val3 = list.get(i3) * 3;
            val5 = list.get(i5) * 5;
            newNum = Math.min(val2, Math.min(val3, val5));
            list.add(newNum);
            if (newNum == val2) { i2++; }
            if (newNum == val3) { i3++; }
            if (newNum == val5) { i5++; }
        }

        return list.get(list.size()-1);
    }
}
