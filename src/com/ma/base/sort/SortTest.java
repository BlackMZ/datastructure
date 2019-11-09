package com.ma.base.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: John.ma
 * @Description: 排序
 * @Date: 2019/2/12 14:41
 */
public class SortTest {
    public static int fun() {
        int x = 1;
        try {
            System.out.println("try block");
            return x;
        } finally {
            ++x;
        }
    }

    public static int fun1() {
        int i = 1;
        try {
            System.out.println("try block");
//            i = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("catch block");
            return 2;
        } finally {
            System.out.println("finally block");
            //return 3;
        }
    }

    public static void main(String[] args) {
        int fun = fun1();
        System.out.println(fun);
        int[] a = {89, 23, 34, 128, 12, 26, 2, 98, 56};
        System.out.println("before:" + Arrays.toString(a));
//        cocktail(a);
//        bubble(a);
//        quick(a, 0, a.length - 1);
//        quickSortTwo(a, 0, a.length - 1);
//        quickSortThree(a, 0, a.length - 1);
//        select(a);
//        insert(a);
//        sheel(a);
//        radix(a);
//        heapSort(a);
//        mergeSortTwo(a, 0, a.length - 1);
//        countSort(a);


        System.out.println("after:" + Arrays.toString(a));


        double[] array = new double[] {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
//        bucketSort(array);
        System.out.println(Arrays.toString(array));

    }


    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void cocktail(int[] a) {
        int length = a.length;
        for (int i = 0; i < length / 2; i++) {
            boolean isSorted = true;
            for (int j = 0; j < length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            for (int j = length - i - 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

        }


//        int length = a.length;
//        int times = 0;
//        for (int i = 0; i < length / 2; i++) {
//            times++;
//            boolean isSorted = true;
//            for (int j = 0; j < length - 1 - i; j++) {
//                if (a[j] > a[j + 1]) {
//                    swap(a, j, j + 1);
//                    isSorted = false;
//                }
//            }
//            if (isSorted) {
//                break;
//            }
//            isSorted = true;
//            for (int j = length - i - 1; j > 0 ; j--) {
//                if (a[j] < a[j - 1]) {
//                    swap(a, j, j - 1);
//                    isSorted = false;
//                }
//            }
//            if (isSorted) {
//                break;
//            }
//        }
//        System.out.println(times);
    }

    //bubble
    public static void bubble(int[] a) {
        int length = a.length;
        int border = length - 1;
        int lastChange = 0;
        for (int i = 0; i < length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < border; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    isSorted = false;
                    lastChange = j;
                }
            }
            border = lastChange;
            if (isSorted) {
                break;
            }
        }


//        int length = a.length;
//        int borderLength = length - 1;
//        int lastindex = 0;
//        for (int i = 0; i < length; i++) {
//            boolean isSorted = true;
//            for (int j = 0; j < borderLength; j++) {
//                if (a[j] > a[j + 1]) {
//                    swap(a, j, j + 1);
//                    isSorted = false;
//                    lastindex = j;
//                }
//            }
//            borderLength = lastindex;
//            if (isSorted) {
//                break;
//            }
//        }

    }

    //quick
    public static void quick(int[] a, int start, int end) {
        if (a == null || start >= end) return;
        int key = a[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && a[j] > key) j--;
            if (i < j) a[i++] = a[j];
            while (i < j && a[i] < key) i++;
            if (i < j) a[j--] = a[i];
        }
        a[i] = key;
        quick(a, start, i - 1);
        quick(a, i + 1, end);

//        if (a == null || start >= end) return;
//        int key = a[start];
//        int i = start, j = end;
//
//        while (i < j) {
//            while (i < j && a[j] >= key) j--;
//            if (i < j) a[i++] = a[j];
//            while (i < j && a[i] <= key) i++;
//            if (i < j) a[j--] = a[i];
//        }
//        a[i] = key;
//        b(a, start, i - 1);
//        b(a, i + 1, end);

    }

    public static void quickSortTwo(int[] a, int start, int end) {
        if (a == null || start >= end) return;
        int key = a[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (a[i] < key) {
                mark++;
                int temp = a[mark];
                a[mark] = a[i];
                a[i] = temp;
            }
        }
        a[start] = a[mark];
        a[mark] = key;
        quickSortTwo(a, start, mark - 1);
        quickSortTwo(a, mark + 1, end);

//        if (a == null || start >= end) return;
//        int key = a[start];
//        int mark = start;
//        for (int i = start + 1; i <= end; i++) {
//            if (a[i] < key) {
//                mark++;
//                swap(a, mark, i);
//            }
//        }
//        a[start] = a[mark];
//        a[mark] = key;
//        quickSortTwo(a, start, mark - 1);
//        quickSortTwo(a, mark + 1, end);
    }

    public static void quickSortThree(int[] a, int start, int end) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        stack.push(map);
        while (!stack.isEmpty()) {
            Map<String, Integer> pop = stack.pop();
            int mark = quickThree(a, pop.get("start"), pop.get("end"));
            if (pop.get("start") < mark - 1) {
                Map<String, Integer> left = new HashMap<>(2);
                left.put("start", pop.get("start"));
                left.put("end", mark - 1);
                stack.push(left);
            }
            if (pop.get("end") > mark + 1) {
                Map<String, Integer> right = new HashMap<>(2);
                right.put("start", mark + 1);
                right.put("end", pop.get("end"));
                stack.push(right);
            }
        }

    }

    public static int quickThree(int[] a, int start, int end) {
        if (a == null || start >= end) return 0;
        int key = a[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (a[i] < key) {
                mark++;
                int temp = a[mark];
                a[mark] = a[i];
                a[i] = temp;
            }
        }
        a[start] = a[mark];
        a[mark] = key;
        return mark;
    }

    //select
    public static void select(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int key = a[i];
            int position = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = key;
        }


//       int length = a.length;
//        for (int i = 0; i < length; i++) {
//            int key = a[i];
//            int position = i;
//            for (int j = i + 1; j < length; j++) {
//                if (a[j] < key) {
//                    key = a[j];
//                    position = j;
//                }
//            }
//            a[position] = a[i];
//            a[i] = key;
//        }
    }

    //insert
    public static void insert(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int insertNum = a[i];
            int j = i - 1;
            for (; j >= 0 && a[j] > insertNum; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = insertNum;
        }

//        int length = a.length;
//        for (int i = 1; i < length; i++) {
//            int insertNum = a[i];
//            int j = i - 1;
//            for (;j >= 0 && a[j] > insertNum; j--) {
//                a[j + 1] = a[j];
//            }
//            a[j + 1] = insertNum;
//        }
    }

    //sheel
    public static void sheel(int[] a) {
        int length = a.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int insertNum = a[i];
                int j = i - gap;
                for (; j >= 0 && a[j] > insertNum; j -= gap) {
                    a[j + gap] = a[j];
                }
                a[j + gap] = insertNum;
            }
        }

//        int length = a.length;
//        for (int gap = length / 2; gap > 0; gap /= 2) {
//            for (int i = gap; i < length; i++) {
//                int insertNum = a[i];
//                int j = i - gap;
//                for (;j >= 0 && a[j] > insertNum; j-=gap) {
//                    a[j + gap] = a[j];
//                }
//                a[j + gap] = insertNum;
//            }
//        }

    }

    //基数排序
    public static void radix(int[] a) {
        int length = a.length;
        int queueNum = 10;

        int max = a[0];
        for (int i = 1; i < length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;
        }
        List<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < queueNum; i++) {
            ArrayList<Integer> queue1 = new ArrayList<>();
            queue.add(queue1);
        }
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < length; j++) {
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(a[j]);
                queue.set(x, queue2);
            }
            int count = 0;
            for (int k = 0; k < queueNum; k++) {
                while (!queue.get(k).isEmpty()) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    a[count++] = queue3.get(0);
                    queue3.remove(0);
                }
            }
        }

//        int length = a.length;
//        int queueNum = 10;
//        int max = a[0];
//        for (int i = 1; i < length; i++) {
//            if (a[i] > max) {
//                max = a[i];
//            }
//        }
//        int time = 0;
//        while (max > 0) {
//            max /= 10;
//            time++;
//        }
//        List<ArrayList> queue = new ArrayList<>();
//        for (int i = 0; i < queueNum; i++) {
//            ArrayList<Integer> queue1 = new ArrayList<>();
//            queue.add(queue1);
//        }
//
//        for (int i = 0; i < time; i++) {
//            for (int j = 0; j < length; j++) {
//                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
//                ArrayList<Integer> queue2 = queue.get(x);
//                queue2.add(a[j]);
//                queue.set(x, queue2);
//            }
//            int count = 0;
//            for (int k = 0; k < queueNum; k++) {
//                while (queue.get(k).size() > 0) {
//                    ArrayList<Integer> queue3 = queue.get(k);
//                    a[count] = queue3.get(0);
//                    queue3.remove(0);
//                    count++;
//                }
//            }
//        }

    }

    public static void heapSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            adjustHeap(a, length - i - 1);
            swap(a, 0, length - i - 1);
        }
    }

    public static void adjustHeap(int[] a, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <= lastIndex) {
                int left = 2 * k + 1;
                if (left < lastIndex && a[left] < a[left + 1]) {
                    left++;
                }
                if (a[k] > a[left]) break;
                swap(a, k, left);
                k = left;
            }
        }
    }

//        System.out.println("开始排序");
//        int length = a.length;
//        for (int i = 0; i < length - 1; i++) {
//            heapAdjust(a, length - 1 - i);
//            swap(a, 0, length - 1 - i);
//            System.out.println("交换后："+Arrays.toString(a));
//        }
//    }
//
//    public static void heapAdjust(int[] a, int lastIndex) {
//        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
//            int k = i;
//            while (k * 2 + 1 <= lastIndex) {
//                int left = 2 * k + 1;
//                if (left < lastIndex && a[left] < a[left + 1]) {
//                    left++;
//                }
//                if (a[k] < a[left]) {
//                    swap(a, k, left);
//                    k = left;
//                } else {
//                    break;
//                }
//            }
//        }
//        System.out.println("初始堆：" + Arrays.toString(a));


    public static void mergeSortTwo(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortTwo(a, start, mid);
            mergeSortTwo(a, mid + 1, end);
            mergeTwo(a, start, mid, end);
        }

//        System.out.println("start=" + start + " end=" + end);
//        if (start < end) {
//            int mid = (start + end) / 2;
//            mergeSortTwo(a, start, mid);
//            mergeSortTwo(a, mid + 1, end);
//            mergeTwo(a, start, mid, end);
//            //System.out.println();
//        }
    }

    public static void mergeTwo(int[] a, int start, int mid, int end) {
        int[] temp = new int[a.length];
        int p1 = start, p2 = mid + 1, k = start;
        while (p1 <= mid && p2 <= end) {
            if (a[p1] <= a[p2]) {
                temp[k++] = a[p1++];
            } else {
                temp[k++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = a[p1++];
        }
        while (p2 <= end) {
            temp[k++] = a[p2++];
        }
        for (int i = start; i <= end; i++) {
            a[i] = temp[i];
        }

//        System.out.println("start=" + start + " mid=" + mid + " end=" + end);
//        int[] temp = new int[a.length];//辅助数组
//        int p1 = start, p2 = mid + 1, k = start;
//        System.out.println("p1=" + p1 + " p2=" + p2 + " k=" + k);
//        while (p1 <= mid && p2 <= end) {
//            if (a[p1] <= a[p2]) {
//                temp[k] = a[p1];
//                k++;
//                p1++;
//            }else {
//                temp[k] = a[p2];
//                k++;
//                p2++;
//            }
//        }
//        while (p1 <= mid) {
//            temp[k] = a[p1];
//            k++;
//            p1++;
//        }
//        while (p2 <= end) {
//            temp[k] = a[p2];
//            k++;
//            p2++;
//        }
//        for (int i = start; i<=end; i++) {
//            a[i] = temp[i];
//        }
    }

    public static void countSort(int[] a) {
        int length = a.length;
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        int d = max - min;
        int[] count = new int[d + 1];
        for (int i = 0; i < length; i++) {
            count[a[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sort = new int[a.length];
        for (int i = length - 1; i >= 0; i--) {
            sort[count[a[i] - min] - 1] = a[i];
            count[a[i] - min]--;
        }
        for (int i = 0; i < length; i++) {
            a[i] = sort[i];
        }
    }

    public static void bucketSort(double[] a) {
        int length = a.length;
        double max = a[0];
        double min = a[0];
        for (int i = 1; i < length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        double d = max - min;
        int bucketNum = a.length;
        ArrayList<LinkedList<Double>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new LinkedList<>());
        }

        for (int i = 0; i < length; i++) {
            int sum = (int) ((a[i] - min) * (bucketNum - 1) / d);
            bucket.get(sum).add(a[i]);
        }

        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }
        int count = 0;
        for (LinkedList<Double> list : bucket) {
            for (Double dd : list) {
                a[count++] = dd;
            }
        }
    }
}
