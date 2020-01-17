package com.ma.base.sort;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/8/6 17:33
 */
public class SearchTest {

    public static void main(String[] args) {
        int[] a = {2, 12, 23, 26, 34, 56, 89, 98, 128, 145, 225, 275, 290, 356, 458, 587};
        int i = halfSearch(a, 89);
        System.out.println(i);
        int[] b = {1, 5, 6, 9, 11, 11, 11, 15, 18, 19};
        int first = binarySearchFirst(b, 11);
        System.out.println(first);
        int last = binarySearchLast(b, 11);
        System.out.println(last);

        int firstBigger = binarySearchFirstBigger(b, 7);
        System.out.println(firstBigger);

        int lastSmaller = binarySearchLastSmaller(b, 7);
        System.out.println(lastSmaller);
    }

    private static int halfSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] == key) {
                return a[mid];
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param array 查找数组
     * @param key   查找元素
     * @return 元素（下标）
     */
    private static int binarySearchFirst(int[] array, int key) {
        int length = array.length;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (array[mid] > key) {
                high = mid - 1;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (array[mid - 1] != key)) return mid;
                else high = mid - 1;
            }
        }
//        if (low < array.length && array[low] == key) return low;
//        else
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param array 查找数组
     * @param key   查找元素
     * @return 元素（下标）
     */
    private static int binarySearchLast(int[] array, int key) {
        int length = array.length;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (array[mid] > key) {
                high = mid - 1;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                if ((mid == (length - 1)) || (array[mid + 1] != key)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param array 查找数组
     * @param key   查找元素
     * @return 元素（下标）
     */
    private static int binarySearchFirstBigger(int[] array, int key) {
        int length = array.length;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (array[mid] > key) {
                if ((mid == 0) || (array[mid - 1] < key)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param array 查找数组
     * @param key   查找元素
     * @return 元素（下标）
     */
    private static int binarySearchLastSmaller(int[] array, int key) {
        int length = array.length;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (array[mid] > key) {
                high = mid - 1;
            } else {
                if ((mid == length - 1) || (array[mid + 1] > key)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

}
