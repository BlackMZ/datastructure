package com.ma.base.array;

import java.util.Arrays;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/11/4 09:37
 */
public class ArrayTest {
    private int[] array;
    private int size;


    public ArrayTest(int capacity) {
        array = new int[capacity];
        this.size = 0;
    }

    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入元素下标不正确！");
        }
        if (size >= array.length) {
            //扩容
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void resize() {
        int[] newarray = new int[array.length * 2];
        System.arraycopy(array, 0, newarray, 0, array.length);
        array = newarray;
    }

    public void add(int element) {
        if (size >= array.length){
            throw new IndexOutOfBoundsException("数组已满，无法添加！");
        }
        array[size++] = element;
    }

    public int delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("删除元素下标不正确！");
        }
        int deleteElement = array[index];
        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteElement;
    }

    public void out() {
        System.out.println(Arrays.toString(array));
    }
    public int size() {
        return size;
    }

    public int getOne(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("查找元素下标不正确！");
        }
        return array[index];
    }

    public static void main(String[] args) {
        ArrayTest myArray = new ArrayTest(4);
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.out();
        int size = myArray.size();
        System.out.println(size);
        myArray.insert(0,3);
        myArray.insert(1,7);
//        myArray.insert(2,9);
//        myArray.insert(3,5);
//        myArray.insert(1,6);
//        myArray.insert(5,8);
        myArray.out();
        myArray.add(10);
        //myArray.delete(3);
        myArray.out();
        System.out.println(myArray.getOne(4));

    }
}
