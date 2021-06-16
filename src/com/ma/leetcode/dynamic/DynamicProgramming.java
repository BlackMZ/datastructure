package com.ma.leetcode.dynamic;

/**
 * @author Arlo
 * @version 1.0.0
 * @Description 动态规划
 * @ClassName DynamicProgramming.java
 * @createTime 2021年04月23日 11:10:00
 */
public class DynamicProgramming {

    /**
     * 结果放到maxW中
     */
    private int maxW = Integer.MAX_VALUE;
    /**
     * 物品重量
     */
    private int[] weight = {2, 2, 4, 6, 3};
    /**
     * 物品个数
     */
    private int n = 5;
    /**
     * 背包承受的最大重量
     */
    private int w = 9;

    // 备忘录，默认值false
    private boolean[][] mem = new boolean[5][10];

    public void f(int i, int cw) {
        // 调用f(0, 0)
        if (cw == w || i == n) {
            // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        // 重复状态
        if (mem[i][cw]) return;
        // 记录(i, cw)这个状态
        mem[i][cw] = true;
        // 选择不装第i个物品
        f(i + 1, cw);
        if (cw + weight[i] <= w) {
            // 选择装第i个物品
            f(i + 1, cw + weight[i]);
        }
    }


    //weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states; //默认值false
        states = new boolean[n][w+1];
        // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {
                // 不把第i个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) {
                //把第i个物品放入背包
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) {
            // 输出结果
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }
}
