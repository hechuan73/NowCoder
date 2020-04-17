package com.chuan.meituan;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 问题：2110年美团外卖火星第3000号配送站点有26名骑手，分别以大写字母A-Z命名，因此可以称呼这些骑手为黄家骑士特工A，黄家骑士特工B…黄家骑士特工Z
 * ，某美团黑珍珠餐厅的外卖流水线上会顺序产出一组包裹，美团配送调度引擎已经将包裹分配到骑手，并在包裹上粘贴好骑手名称，如RETTEBTAE代表一组流水线
 * 包裹共9个，同时分配给了名字为A B E R T的5名骑手。请在不打乱流水线产出顺序的情况下，把这组包裹划分为尽可能多的片段，同一个骑手只会出现在其中
 * 的一个片段，返回一个表示每个包裹片段的长度的列表。
 *
 * 输入：输入数据只有一行，为一个字符串(不包含引号)，长度不超过1000，只包含大写字母'A'到'Z'，字符之间无空格。
 * 输出：输出每个分割成片段的包裹组的长度，每个长度之间通过空格隔开。
 * @author hechuan
 */
public class PacketSegments {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String riders = scanner.next();
        // 记录每一个骑手最后出现的位置
        int[] counter = new int[26];
        for (int i = 0; i < riders.length(); i++) {
            counter[riders.charAt(i)-'A'] = i;
        }

        HashSet<Character> nextRemain = new HashSet<>();
        int start = 0;
        char cha;
        for (int i = 0; i < riders.length(); i++) {
            cha = riders.charAt(i);
            if (counter[cha] > i) {
                nextRemain.add(cha);
            }
            else {
                nextRemain.remove(cha);
            }
            if (nextRemain.isEmpty()) {
                System.out.print(i-start+1) ;
                if (i != riders.length()-1) {
                    System.out.print(" ");
                    start = i+1;
                }
            }
        }
    }
}
