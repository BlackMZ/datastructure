package com.ma.leetcode;

import java.util.Arrays;

/**
 * @Author: John.ma
 * @Description: 获取数字组合序列比原组合大，且最接近原组合的 数字组合，
 * @Date: 2019/11/18 09:39
 */
public class GetNearestNumber {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};
        //打印12345之后的10个全排列整数
        for(int i=0; i<10;i++){
            numbers = getNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    private static void outputNumbers(int[] numbers){
        for(int i : numbers){
            System.out.print(i);
        }
        System.out.println();
    }
    private static int[] getNearestNumber(int[] number) {
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = getTransferPoint(number);
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回null
        if(index == 0){
            return null;
        }
        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        //拷贝入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(number, number.length);
        exchangeHead(numbersCopy, index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int getTransferPoint(int[] number) {
        for (int i = number.length - 1; i > 0; i--) {
            if (number[i] > number[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static void exchangeHead(int[] number, int index) {
        int head = number[index - 1];
        for (int i = number.length - 1; i > 0; i--) {
            if (head < number[i]) {
                number[index - 1] = number[i];
                number[i] = head;
                break;
            }
        }
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }


}
