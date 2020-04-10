package com.ma.leetcode;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2020/4/10 08:49
 */
public class Binary {
    /**
     * 获取从 0 到 num 每个数二进制的有 1 的数量
     * @param num
     * @return
     */
    public static int[] getBinaryCount(int num) {
        int[] x = new int[num + 1];
        x[0]=  0;
        x[1]=  1;
        for (int i = 2; i <= num ; i++) {
            if(i % 2 == 0) {
                x[i] = x[i/2];
            } else {
                x[i] = x[i/2] + 1;
            }
        }
        return x;
    }
}
