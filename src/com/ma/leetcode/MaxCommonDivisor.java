package com.ma.leetcode;

/**
 * @Author: John.ma
 * @Description: 获取两个数的最大公约数
 * @Date: 2019/11/6 09:03
 */
public class MaxCommonDivisor {

    public static int getMaximumCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        for (int i = small / 2; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static int getMaximumCommonDivisorTwo(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getMaximumCommonDivisorTwo(big % small, small);
    }

    public static int getMaximumCommonDivisorThree(int a, int b) {
//        System.out.println("a=" + a + " b=" + b);
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getMaximumCommonDivisorThree(big - small, small);
    }

    public static int mcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return mcd(a >> 1, b >> 1) << 1;
        } if ((a & 1) == 0 && (b & 1) != 0) {
            return mcd(a >> 1, b);
        } if ((a & 1) != 0 && (b & 1) == 0) {
            return mcd(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return mcd(big - small, small);
        }
    }

    public static void main(String[] args) {
        int commonDivisor = getMaximumCommonDivisor(24, 12);
        System.out.println(commonDivisor);
        int commonDivisorTwo = getMaximumCommonDivisorTwo(24, 12);
        System.out.println(commonDivisorTwo);

        int commonDivisorThree = getMaximumCommonDivisorThree(24, 15);
        System.out.println(commonDivisorThree);

        int mcd = mcd(24, 12);
        System.out.println(mcd);

        System.out.println(15 << 2);
        System.out.println(15 & 3);
        System.out.println(15 ^ 3);
        System.out.println(~1);
        System.out.println(~2);
        System.out.println(~3);
        System.out.println(~7);
        System.out.println(16>>>3);
        System.out.println(16>>3);

        System.out.println(-5 >> 3);
        System.out.println(Integer.toBinaryString(~-10));
        System.out.println(Integer.toBinaryString(-10));

    }
}
