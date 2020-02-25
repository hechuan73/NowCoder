package sword_offers;

public class RegularExpressionMatching_51 {

    public boolean match(char[] str, char[] pattern) {
        return doMatch(str, 0, pattern, 0);
    }

    private boolean doMatch(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) { return true; }
        if (strIndex != str.length && patternIndex == pattern.length) { return false; }

        // we should consider whether the next char in pattern is '*' as two cases:
        if (patternIndex+1 < pattern.length && pattern[patternIndex+1] == '*') {
            if (strIndex < str.length) {
                if (pattern[patternIndex] == '.') {
                    // for str: "abba", pattern = "a.*a" and  str: "aa", pattern = "a.*a".
                    return doMatch(str, strIndex+1, pattern, patternIndex)
                            || doMatch(str, strIndex, pattern, patternIndex+2); }
                else {
                    if (str[strIndex] == pattern[patternIndex]) {
                        // for str: "aab", pattern = "a*a" and  str: "aa", pattern = "a*a".
                        return doMatch(str, strIndex+1, pattern, patternIndex)
                                || doMatch(str, strIndex, pattern, patternIndex+2); }

                    return doMatch(str, strIndex, pattern, patternIndex+2);
                }
            }

            // for pattern[patternIndex+1] == '*', such as['.', '*'], but str = [].
            return doMatch(str, strIndex, pattern, patternIndex+2);

        }

        if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            return doMatch(str, strIndex+1, pattern, patternIndex+1);
        }

        return false;
    }
}
