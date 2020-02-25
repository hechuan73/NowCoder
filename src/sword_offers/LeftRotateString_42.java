package sword_offers;

/**
 * @author hechuan
 */
public class LeftRotateString_42 {

    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0) { return str; }
        int shift = n % len;
        return str.substring(shift) + str.substring(0, shift);
    }
}
