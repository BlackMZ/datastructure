package com.ma.leetcode;

/**
 * @Author: John.ma
 * @Description: 在一组数字中，去除k个数字，使剩下的数字最小
 * @Date: 2019/11/26 09:17
 */
public class RemoveDigits {

    public static void main(String[] args) {
        System.out.println(removeKDigitsB("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("541270936", 3));
        System.out.println(removeKDigits("1593212", 4));
        System.out.println(removeKDigits("1000020000000010", 2));
        String num = "6589254";
        String s = removeKDigits(num, 2);
        System.out.println(s);
        System.out.println(removeKDigits("1000020000000010", 2));
    }

    private static String removeKDigitsB(String num, int k) {
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1, num.length());
                    hasCut = true;
                    break;
                }
            }
            if (!hasCut) {
                num = num.substring(0, num.length() - 1);
            }
        }
        int start = 0;
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) != '0') {
                break;
            }
            start++;
        }
        num = num.substring(start, num.length());
        if (num.length() == 0) {
            return "0";
        }
        return num;
    }


    private static String removeKDigits(String num, int k) {
        int newlength = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char key = num.charAt(i);
            while (top > 0 && stack[top - 1] > key && k > 0) {
                top--;
                k--;
            }

            if ('0' == key && top == 0) {
                newlength--;
                if (newlength <= 0) {
                    return "0";
                }
                continue;
            }
            stack[top++] = key;
        }
        return newlength <= 0 ? "0" : new String(stack, 0, newlength);
    }
}
