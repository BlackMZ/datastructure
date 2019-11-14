package com.ma.leetcode;

/**
 * @Author: John.ma
 * @Description: 获取数组排序后，得到相邻元素最大的差值;
 * @Date: 2019/11/13 09:16
 */
class Bucket {
    Integer min;
    Integer max;
}

public class MaxSortDistance {

    public static int getMaxDestance(int[] array) {
        int length = array.length;
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int d = max - min;
        if (d == 0) {
            return 0;
        }
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < length; i++) {
            buckets[i] = new Bucket();
        }
        for (int i = 0; i < length; i++) {
            int num = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[num].min == null || buckets[num].min > array[i]) {
                buckets[num].min = array[i];
            }
            if (buckets[num].max == null || buckets[num].max < array[i]) {
                buckets[num].max = array[i];
            }
        }
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] a = new int[]{15,2,23,9,78,26};
        int maxDestance = getMaxDestance(a);
        System.out.println(maxDestance);


    }
}
