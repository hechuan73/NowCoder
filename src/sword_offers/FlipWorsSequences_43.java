package sword_offers;

/**
 * @author hechuan
 */
public class FlipWorsSequences_43 {

    public String ReverseSentence(String str) {
        if (str.length() == 0) { return str; }
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        // if strings.length == 0, means there are all spaces in the str.
        return strings.length == 0 ? str : sb.deleteCharAt(sb.length()-1).toString();
    }
}
