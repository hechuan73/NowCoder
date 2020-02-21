package sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class PermutationsWithNoDuplicatedAndOrderedSequence_27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() != 0) {
            boolean[] visited = new boolean[str.length()];
            backtracking(str, new StringBuilder(), res, visited);
        }
        return res;
    }

    private void backtracking(String str, StringBuilder sb, ArrayList<String> res, boolean[] visited) {
        if (sb.length() == str.length()) {
            res.add(new String(sb));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (visited[i] || (i > 0 && visited[i-1] && str.charAt(i) == str.charAt(i-1))) { continue; }
            visited[i] = true;
            sb.append(str.charAt(i));
            backtracking(str, sb, res, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
