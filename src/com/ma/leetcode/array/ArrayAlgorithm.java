package com.ma.leetcode.array;

import com.sun.javafx.image.IntPixelGetter;
import javafx.geometry.Pos;
import jdk.nashorn.internal.ir.WhileNode;

import javax.management.relation.Role;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.*;

/**
 * @Author: John.ma
 * @Description: 数组相关算法题
 * @Date: 2019/10/29 10:07
 */
public class ArrayAlgorithm {

    /**
     * @param array
     * @param key
     * @return
     */
    public static int[] twoSum(int[] array, int key) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int temp = key - array[i];
            for (int j = i + 1; j < length; j++) {
                if (array[j] == temp) {
                    return new int[]{i, j};
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

    /**
     * Given an array of integers that is already sorted in ascending order,
     * find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2.
     * Your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumSorted(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int key = target - numbers[i];
            for (int j = i + 1; j < length; j++) {
                if (key == numbers[j]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumSortedTwo(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int key = target - numbers[i];
            int low = i + 1;
            int high = length - 1;
            int mid;
            while (low <= high) {
                mid = low + ((high - low) >> 1);
                if (numbers[mid] > key) {
                    high = mid - 1;
                } else if (numbers[mid] < key) {
                    low = mid + 1;
                } else if (numbers[mid] == key) {
                    return new int[]{i + 1, mid + 1};
                }
            }
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

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int i = 0;
        for (int j = 1; j < length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        int j = length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    j--;
                } else {
                    swap(nums, i, j);
                    i++;
                    j--;
                }
            } else {
                i++;
            }
        }
        return i;
//        int i = 0;
//        for (int j = 0; j < length; j++) {
//            if (nums[j] != val) {
//                nums[i] = nums[j];
//                i++;
//            }
//        }
//        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int insert = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                return i;
            } else {
                if (nums[i] < target) {
                    insert++;
                }
            }

        }
        return insert;

//        for (int i = 0; i < length; i++) {
//            if (nums[i]>=target) return i;
//        }
//        return length;
    }

    public static int searchInsertTwo(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1, insert = length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            //int midtwo = (right + left) / 2;
            //System.out.println(mid == midtwo);
            if (target <= nums[mid]) {
                insert = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return insert;

//        int left = 0, right = n - 1, ans = n;
//        while (left <= right) {
//            int mid = ((right - left) >> 1) + left;
//            if (target <= nums[mid]) {
//                ans = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
    }

    /**
     * 给定一个整数数组 nums ，
     * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int preSum = nums[0];
        int maxSum = nums[0];
        int curSum;
        for (int j = 1; j < length; j++) {
            int curNum = nums[j];
            if (preSum > 0) {
                curSum = curNum + preSum;
            } else {
                curSum = curNum;
            }
            preSum = curSum;
            if (maxSum < curSum) {
                maxSum = curSum;
            }
        }

        return maxSum;

//        List<Integer> maxList = new ArrayList<>();
//        for (int i = 0; i < length; i++) {
//            int max = nums[i];
//            maxList.add(max);
//            for (int j = i + 1; j < length; j++) {
//                max+=nums[j];
//                maxList.add(max);
//            }
//        }
//        int s = maxList.get(0);
//        for (int i = 1; i < maxList.size(); i++) {
//            if(maxList.get(i) > s) {
//                s = maxList.get(i);
//            }
//        }
//        return s;
    }

    public static int maxSubArrayTwo(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            int last = nums[i - 1];
            if (last > 0) {
                nums[i] += last;
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，
     * 在该数的基础上加一。最高位数字存放在数组的首位，
     * 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int x = 0;
        boolean isTen = false;
        for (int i = length - 1; i >= 0; i--) {
            int add = isTen ? digits[i] + x : digits[i] + 1;
            // 判断一个数是否被10整除，i % 10
            if (add >= 10) {
                isTen = true;
                x = 1;
                digits[i] = 0;
            } else {
                digits[i] = add;
                return digits;
            }
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
//        int[] temp;
//        if (isTen) {
//            temp = new int[length + 1];
//            temp[0] = 1;
//            System.arraycopy(digits, 0, temp, 1, length - 1);
//            return temp;
//        } else {
//            return digits;
//        }
    }

    public static int[] plusOneTwo(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素  。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int[] temp = new int[length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        //nums1 = new int[m + n];
        for (int l = 0; l < length; l++) {
            nums1[l] = temp[l];
        }
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(1);
            for (int j = 0; j < i; j++) {
                if (!triangle.isEmpty()) {
                    List<Integer> nums = triangle.get(i - 1);
                    if ((j + 1) < nums.size()) {
                        int add = nums.get(j) + nums.get(j + 1);
                        single.add(add);
                    }
                }
            }
            if (i > 0) {
                single.add(1);
            }
            triangle.add(single);
        }
        return triangle;
    }

    public static List<List<Integer>> triangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> single = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    single.add(1);
                } else {
                    single.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(single);
        }
        return triangle;
    }

    /**
     * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
     * Notice that the row index starts from 0.
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> triangle = new ArrayList<>();
        if (rowIndex <= 1) {
            for (int i = 0; i <= rowIndex; i++) {
                triangle.add(1);
            }
            return triangle;
        } else {
            List<Integer> row = getRow(rowIndex - 1);
            for (int i = 0; i <= rowIndex; i++) {
                if (i == 0 || i == rowIndex) {
                    triangle.add(1);
                } else {
                    triangle.add(row.get(i) + row.get(i - 1));
                }
            }
            return triangle;
        }
    }

    /**
     * 动态规划 转息leetcode
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRows(int rowIndex) {
        int[] num = new int[rowIndex + 1];
        List<Integer> triangle = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            num[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                num[j] = num[j] + num[j - 1];
            }
        }
        for (int a : num) {
            triangle.add(a);
        }
        return triangle;

    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     * Note that you cannot sell a stock before you buy one.
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                int profit = prices[j] - prices[i];
                if (profit > 0 && profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次循环
     *
     * @param prices
     * @return
     */
    public static int maxProfitWithOneLoop(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int i = 0, j = 1;
        while (i < length && j < length) {
            int profit = prices[j] - prices[i];
            if (profit > 0) {
                if (maxProfit < profit) {
                    maxProfit = profit;
                }
                //j++;
            } else {
                i = j;
                //j++;
            }
            j++;
        }
        return maxProfit;
    }

    /**
     * Say you have an array prices for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e.,
     * buy one and sell one share of the stock multiple times).
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     * @param prices [7,1,5,3,6,4]  [1,2,3,4,5] [7,6,4,3,1]
     * @return
     */
    public static int maxProfitTwo(int[] prices) {
        int length = prices.length;
        if (length == 0 || length == 1) return 0;
        int buyingPrice = prices[0];
        int buyingPosition = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] < buyingPrice) {
                buyingPrice = prices[i];
                buyingPosition = i;
            } else {
                break;
            }
        }
        if (buyingPosition == length - 1) {
            return 0;
        }
        int sellingPrice = prices[buyingPosition + 1];
        int sellPosition = buyingPosition + 1;
        for (int i = sellPosition + 1; i < length; i++) {
            if (prices[i] > sellingPrice) {
                sellingPrice = prices[i];
                sellPosition = i;
            } else {
                break;
            }
        }
        int profit = sellingPrice - buyingPrice;
        int[] leftPrice = new int[length - sellPosition - 1];

        if (sellPosition < length - 1) {
            leftPrice = Arrays.copyOfRange(prices, sellPosition + 1, length);
//            int count = 0;
//            for (int i = sellPosition + 1; i < length; i++) {
//                leftPrice[count++] = prices[i];
//            }
        }
        return profit + maxProfitTwo(leftPrice);
    }

    public static int maxProfitInMultipleTransaction(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int i = 0, j = 1;
        while (i < length && j < length) {
            int profit = prices[j] - prices[i];
            if (profit > 0) {
                maxProfit += profit;
            }
            i++;
            j++;
        }
        return maxProfit;
//        int ans = 0;
//        int n = prices.length;
//        for (int i = 1; i < n; ++i) {
//            ans += Math.max(0, prices[i] - prices[i - 1]);
//        }
//        return ans;
    }

    /**
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * <p>
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int length = nums.length;
        int size = length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > size) {
                return key;
            }
        }
        throw new IllegalArgumentException("No solution");

//        Arrays.sort(nums);
//        return nums.length / 2;
    }

    /**
     * Given an array of integers, find if the array contains any duplicates.
     * <p>
     * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsDuplicateTwo(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <length; j++) {
                if (nums[j] == nums[i] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateWithOneLoop(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] sorted = new int[]{2, 3, 4, 5};
        int i2 = searchInsertTwo(sorted, 4);
        System.out.println(i2);
        System.out.println(Arrays.toString(sorted));
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(array);
        System.out.println(i);


        int[] nums = new int[]{1,0,1,1};
        boolean b = containsNearbyDuplicateWithOneLoop(nums, 1);
        System.out.println(b);

    }
}
