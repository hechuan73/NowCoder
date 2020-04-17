package com.chuan.pdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hechuan
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        String num = scanner.next();
        int[] counter = new int[10];
        int index;
        int maxTimes = Integer.MIN_VALUE, maxTimesIndex = -1;
        for (int i = 0; i < num.length(); i++) {
            index = num.charAt(i)-'0';
            counter[index]++;
            if (counter[index] > maxTimes) {
                maxTimes = counter[index];
                maxTimesIndex = index;
            }
        }

        if (maxTimes >= k) {
            System.out.println(0);
            System.out.println(num);
        }
        else {
            int diff = k-maxTimes;
            int left = maxTimesIndex-1, right = maxTimesIndex+1;
            int leftLost = Integer.MAX_VALUE;
            int rightLost = Integer.MAX_VALUE;
            Map<Integer, Integer> replaceNums = new HashMap<>();
            long cost = 0;
            while (left>=0 || right < n) {
                if (diff <= 0) { break;}

                if (left >= 0) { leftLost = Math.abs(left-maxTimesIndex); }
                if (right < n) { rightLost = Math.abs(right-maxTimesIndex); }

                if (leftLost < rightLost) {
                    if (diff > counter[left]) {
                        replaceNums.put(left, counter[left]);
                        diff -= counter[left];
                        cost += counter[left] * leftLost;
                    }
                    else {
                        replaceNums.put(left, diff);
                        diff = 0;
                        cost += diff * leftLost;
                    }
                    left--;
                }
                else {
                    if (diff > counter[right]) {
                        replaceNums.put(right, counter[right]);
                        diff -= counter[right];
                        cost += counter[right] * rightLost;
                    }
                    else {
                        replaceNums.put(right, diff);
                        diff = 0;
                        cost += diff * rightLost;
                    }
                    right++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num.length(); i++) {
                index = num.charAt(i) - '0';
                if (replaceNums.containsKey(index) && replaceNums.get(index) > 0) {
                    sb.append(maxTimesIndex);
                    replaceNums.put(index, replaceNums.get(index)-1);
                }
                else {
                    sb.append(index);
                }
            }

            System.out.println(cost);
            System.out.println(sb);
        }
    }
}
