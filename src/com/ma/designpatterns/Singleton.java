package com.ma.designpatterns;

import javax.sound.midi.Soundbank;
import javax.swing.*;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2020/5/21 14:32
 */
public class Singleton {
    private volatile static Singleton singleton;

    public Singleton(){

    }
    public static Singleton getUniqueInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void get(){
        System.out.println("gg");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("A");
        }
//        new Thread(() -> {
//
//        }, "线程 1").start();
//
//        for (int i = 0; i < 10; i++) {
//            int k = i;
//            new Thread(() -> {
//                System.out.println(Thread.currentThread() + " " + k);
//            }, "线程 " + k).start();
//        }

    }
}
