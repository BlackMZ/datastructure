package com.ma.leetcode;

/**
 * Backtracking algorithm
 * Eight queens
 *
 * @author Arlo
 * @version 1.0
 * @date 2020-12-15
 */
public class EightQueens {

    /**
     * 全局或成员变量，下标表示行，值表示 queen 存储在哪一列
     */
    int[] result = new int[8];

    /**
     * 调用方式 cal8queens(0)
     *
     * @param row
     */
    public void cal8queens(int row) {
        //8个棋子都放置好了，打印结果
        if (row == 8) {
            printQueens(result);
            return;
        }
        //每一行都有8种放法
        for (int column = 0; column < 8; ++column) {
            //有些放法不满足要求
            if (isOk(row, column)) {
                //第row行的棋子放到了column列
                result[row] = column;
                //考察下一行
                cal8queens(row + 1);
            }
        }
    }

    /**
     * 判断row行column放置是否合适
     *
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        //逐行往上考察每一行
        for (int i = row - 1; i >= 0; --i) {
            //第i行的column列有棋子么
            if (result[i] == column) return false;
            //考察左上对角线：第i行的leftup列有棋子么
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }
            //考察右上对角线：第i行rightup有棋子么
            if (rightup < 8) {
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8queens(0);
    }
}
