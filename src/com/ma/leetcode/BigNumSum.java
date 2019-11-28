package com.ma.leetcode;

/**
 * 大数字相加
 * @author mz
 * @date  2019-11-28
 */
public class BigNumSum {

    public static int[] getArray(String bigNumber, int maxLength) {
        int[] array = new int[maxLength + 1];
        for (int i = 0; i < bigNumber.length(); i++) {
            array[i] = bigNumber.charAt(bigNumber.length() - i - 1) - '0';
        }
        return array;
    }

    public static String bigNumSum(String bigNumberA, String bigNumberB) {
        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
        int[] arrayA = getArray(bigNumberA, maxLength);
        int[] arrayB = getArray(bigNumberB, maxLength);
        int[] result = new int[maxLength + 1];
        for (int i = 0; i < maxLength; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0 ; i--) {
            if (!findFirst){
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = bigNumSum("12345678", "87654321");
        System.out.println(s);
    }
}
