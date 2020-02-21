package sword_offers;

/**
 * @author hechuan
 */
public class FirstNotRepeatingChar_34 {

    public int FirstNotRepeatingChar(String str) {
        int[] counter = new int['z'-'A'];

        for (int i = 0; i < str.length(); i++) {
            counter[str.charAt(i)-'A']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (counter[str.charAt(i)-'A'] == 1) { return i; }
        }
        return -1;
    }
}
