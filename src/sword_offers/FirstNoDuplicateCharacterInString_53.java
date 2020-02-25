package sword_offers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class FirstNoDuplicateCharacterInString_53 {

    private LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    public void Insert(char ch) {
        map.put(ch, map.getOrDefault(ch, 0)+1);
    }
    /**
     * return the first appearance once char in current string stream.
     */
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) { return entry.getKey(); }
        }

        return '#';
    }
}
