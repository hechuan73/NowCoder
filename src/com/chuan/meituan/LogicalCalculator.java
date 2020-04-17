package com.chuan.meituan;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 问题：给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，现在要对这个表达式进行布尔求值，计算
 * 结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。表达式求值是注意and 的优先级比 or 要高，比如：true or
 * false and false，等价于 true or (false and false)，计算结果是 true。
 *
 * 输入：输入第一行包含布尔表达式字符串s，s只包含true、false、and、or几个单词（不会出现其它的任何单词），且单词之间用空格分隔。(1 ≤|s|≤103).
 * 输出：true、false或error，true表示布尔表达式计算为真，false表示布尔表达式计算为假，error表示一个不合法的表达式。
 * @author hechuan
 */
public class LogicalCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> operators = new HashSet<>();
        operators.add("and");
        operators.add("or");
        ArrayDeque<String> numberStack = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        for (String str : strings) {
            if (operators.contains(str)) {
                if (numberStack.size()-1 != operatorStack.size()) {
                    System.out.println("error");
                    return;
                }
                else {
                    operatorStack.offer(str);
                }
            }
            else {
                if (numberStack.size() != operatorStack.size()) {
                    System.out.println("error");
                    return;
                }

                if (numberStack.size() > 0){
                    if ("and".equals(operatorStack.peekLast())) {
                        String res = String.valueOf(
                                Boolean.logicalAnd(Boolean.parseBoolean(str), Boolean.parseBoolean(numberStack.pollLast())));
                        numberStack.offer(res);
                        operatorStack.pollLast();
                    }
                    else {
                        numberStack.offer(str);
                    }
                }
                else {
                    numberStack.offer(str);
                }
            }
        }

        boolean res = false;
        while (!numberStack.isEmpty()) {
            if ("true".equals(numberStack.poll())) {
                res = true;
                break;
            }
        }

        System.out.println(res);
        scanner.close();
    }
}
