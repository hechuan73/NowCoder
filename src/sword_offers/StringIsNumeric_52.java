package sword_offers;

/**
 * @author hechuan
 */
public class StringIsNumeric_52 {

    public boolean isNumeric(char[] str) {
        if (str.length == 0) { return false; }
        int eCount = 0, dotCount = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                // for case: "12e+3".
                if (i != 0 && (str[i-1] != 'e' || str[i-1] != 'E')) { return false; }
                continue;
            }

            if (str[i] == 'e' || str[i] == 'E') {
                if (eCount++ > 0 || i == 0 || i == str.length-1) { return false; }
                continue;
            }

            if (str[i] == '.') {
                // "1.e3" is ok.
                if (dotCount++ > 0|| i == 0 || i == str.length-1) { return false; }
                // for case: "12e4.3"
                if (dotCount > 0 && eCount > 0) { return false; }
                continue;
            }

            if (str[i] > '9' || str[i] < '0') { return false; }
        }

        return true;
    }
}
