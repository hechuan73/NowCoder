package sword_offers;

/**
 * @author hechuan
 */
public class TraverseStringToInteger_48 {

    public int StrToInt(String str) {
        long res = 0;
        int flag = 1;
        if (str.length() > 0) {
            char cha = str.charAt(0);
            if (cha == '-') { flag = -1; }
            else if (cha >= '0' && cha <= '9') { res += Integer.parseInt(cha+""); }
            else if (cha >= 'A') { return 0; }

            for (int i = 1; i < str.length(); i++) {
                cha = str.charAt(i);
                if (cha < '0' || cha > '9') { return 0; }
                else { res = res *10 + Integer.parseInt(cha+""); }
                if (flag == 1 && res > Integer.MAX_VALUE) { return 0; }
                if (flag == -1 && res*flag < Integer.MIN_VALUE) { return 0; }
            }
        }

        return flag * (int) res;
    }
}
