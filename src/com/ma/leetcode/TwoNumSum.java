package com.ma.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/10/29 10:07
 */
public class TwoNumSum {

    public static int[] twoSum(int[] array, int key) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int temp = key - array[i];
            for (int j = i + 1; j < length; j++) {
                if (array[j] == temp) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumTwo(int[] array, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < length; i++) {
            int temp = key - array[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{i, map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumThree(int[] array, int key) {
        int length = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int temp = key - array[i];
            if (map.containsKey(temp)) {
                return new int[]{i, map.get(temp)};
            }
            map.put(array[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static boolean isString(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            String x = String.valueOf(chars[start]);
            String y = String.valueOf(chars[end]);
            if (!x.equals(y)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPowerOfTwo(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 5, 6, 15, 9,21};
        int[] ints = twoSum(array, 15);
        System.out.println(Arrays.toString(ints));
        int[] ints1 = twoSumTwo(array, 15);
        System.out.println(Arrays.toString(ints1));

        int[] ints2 = twoSumThree(array, 15);
        System.out.println(Arrays.toString(ints2));

        String s = "ababa";
        System.out.println(isString(s));

        System.out.println(isPowerOfTwo(16));
    }
}
