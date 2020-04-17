package com.chuan.sword_offers;

/**
 * @author hechuan
 */
public class ReplaceSpaces_2 {

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            sb.append(ch == ' ' ? "%20" : ch);
        }

        return sb.toString();
    }
}
