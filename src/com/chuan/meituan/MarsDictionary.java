package com.chuan.meituan;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 问题：已知一种新的火星文的单词由英文字母（仅小写字母）组成，但是此火星文中的字母先后顺序未知。给出一组非空的火星文单词，且此组单词已经按火星文
 * 字典序进行好了排序（从小到大），请推断出此火星文中的字母先后顺序。
 *
 * 输入：一行文本，为一组按火星文字典序排序好的单词(单词两端无引号)，单词之间通过空格隔开。
 * 输出：按火星文字母顺序输出出现过的字母，字母之间无其他字符，如果无法确定顺序或者无合理的字母排序可能，请输出"invalid"(无需引号)
 *
 * 思路：先根据词的排序得到字母的有向无环图，a->b代表字母a在字母b的字典序前面，然后得出该图的拓扑序即可。时间T(n)
 *
 * @author hechuan
 */
public class MarsDictionary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        String[] words = string.split(" ");
        if (words.length == 0) {
            System.out.println("invalid");
            return;
        }

        HashSet<Character> chas = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                chas.add(word.charAt(i));
            }
        }

        HashSet<Character>[] adjList = new HashSet[26];
        int[] inDegrees = new int[26];
        String prev, curr;
        char origin, destination;
        int len, index;
        // 通过输入来构建边
        for (int i = 1; i < words.length; i++) {
            prev = words[i-1];
            curr = words[i];
            len = Math.min(prev.length(), curr.length());
            for (int j = 0; j < len; j++) {
                origin = prev.charAt(j);
                destination = curr.charAt(j);
                // 找到第一个不匹配的字符，建立边
                if (origin != destination) {
                    index = origin-'a';
                    if (adjList[index] == null) {
                        adjList[index] = new HashSet<>();
                    }
                    if (!adjList[index].contains(destination)) {
                        adjList[index].add(destination);
                        inDegrees[destination-'a']++;
                    }
                    break;
                }
            }
        }

        // 拓扑排序
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        char cha;
        for (int i = 0; i < inDegrees.length; i++) {
            cha = (char)(i+'a');
            if (inDegrees[i] == 0 && adjList[i] != null) {
                queue.add(cha);
            }
        }

        while (!queue.isEmpty()) {
            // 严格保证字典序：即每次只能有一个字符在前面
            if (queue.size() != 1) {
                System.out.println("invalid");
                return;
            }
            origin = queue.poll();
            sb.append(origin);
            if (adjList[origin - 'a'] != null) {
                for (Character ch : adjList[origin - 'a']) {
                    inDegrees[ch-'a']--;
                    if (inDegrees[ch-'a'] == 0) {
                        queue.add(ch);
                    }
                }
            }
        }

        System.out.println(sb.length() == chas.size() ? sb : "invalid");
    }
}
