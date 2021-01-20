package com.company;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;

public class Main {
    static final int size = 1000000;
    static final int halfSize = size / 2;

    public static void main(String[] args) {
        // определим количество потоков процессора
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        int threadCount = threadBean.getThreadCount();

        Thread t1 = new Thread(new Runnable() {
            float[] arrOne = new float[size];

            @Override
            public void run() {
                //заполним массив единицами
                for (int i = 0; i < arrOne.length; i++) {
                    arrOne[i] = 1;
                }

                long a = System.currentTimeMillis();

                //изменим значения массива
                for (int i = 0; i < arrOne.length; i++) {
                    arrOne[i] = (float)(arrOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

                System.out.println("поток 1: " + (System.currentTimeMillis() - a));
            }
        });

        t1.start();
        hren();
    }

    public static void hren() {
        float[] arrTwo = new float[size];

        float[] arr1 = new float[halfSize];
        float[] arr2 = new float[halfSize];

        long b = System.currentTimeMillis();

        //заполним массив единицами
        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = 1;
        }

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // разделим массив
                System.arraycopy(arrTwo, 0, arr1, 0, halfSize);

                //изменим значения массива
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

                // склеим массивы
                System.arraycopy(arr1, 0, arrTwo, 0, halfSize);

                System.out.println("поток 2.1: " + (System.currentTimeMillis() - b));
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                // разделим массив
                System.arraycopy(arrTwo, halfSize, arr2, 0, halfSize);

                //изменим значения массива
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

                // склеим массивы
                System.arraycopy(arr2, 0, arrTwo, halfSize, halfSize);

                System.out.println("поток 2.2: " + (System.currentTimeMillis() - b));
            }
        });

        t3.start();
        t4.start();
    }
}
