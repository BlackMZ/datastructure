package com.ma.leetcode.array;

import com.sun.org.apache.bcel.internal.generic.IADD;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import sun.security.util.Length;

import javax.management.MXBean;
import javax.naming.NameNotFoundException;
import javax.sound.midi.Soundbank;
import java.util.*;

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

    public static void main(String[] args) {
        int[] sorted = new int[]{2, 3, 4, 5};
        int i2 = searchInsertTwo(sorted, 4);
        System.out.println(i2);
        System.out.println(Arrays.toString(sorted));
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(array);
        System.out.println(i);

        int[] plus = new int[]{1, 9};
        int[] ints = plusOne(plus);
        System.out.println(Arrays.toString(ints));
    }
}
