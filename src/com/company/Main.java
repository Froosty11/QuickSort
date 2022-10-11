package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static QuickLink randomLinkedList(int n){
        QuickLink l = new QuickLink();
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            l.appendData(rd.nextInt(n*10));
        }
        return l;
    }
    public static int[] randomArray(int n){
        int[] array = new int[n];
        Random rd = new Random();
        for(int i = 0 ; i < n; i++){
            array[i] = rd.nextInt(n);
        }
        return array;
    }



    public static void main(String[] args) {
        long t_Start;
        long t_temp;
        long arraySum;
        long arrayMax;
        long linkedSum;
        long linkedMax;
        long arrayMin;
        long linkedMin;
        int iterations = 1000;
        int[] nList = {8, 16, 32, 128, 512, 1024, 2048, 4096, 8192, 8192*2,8192*4};
            for (int n : nList) {
                //fill array
                arraySum = 0;
                linkedSum = 0;
                arrayMin = (int) Double.POSITIVE_INFINITY;
                linkedMin = (int) Double.POSITIVE_INFINITY;
                linkedMax = 0;
                arrayMax = 0;
                int[] OGArray = randomArray(n);
                int[] comparisonArray = Arrays.copyOf(OGArray, n);
                Arrays.sort(comparisonArray);
                for(int j = 0; j < iterations; j++) {
                    QuickLink ql = randomLinkedList(n);
                    int[] useArray = Arrays.copyOf(OGArray, n);
                    t_Start= System.nanoTime();
                    QuickSort.quickSort(useArray, 0, useArray.length-1);
                    t_temp = System.nanoTime() - t_Start;

                    if(Arrays.compare(comparisonArray, useArray) == 0) {
                        arraySum += t_temp;
                        if(t_temp < arrayMin) arrayMin    = t_temp;
                        if(t_temp > arrayMax) arrayMax = t_temp;
                    }
                    else System.out.println("Error! Not Array sorted.");
                    t_Start= System.nanoTime();
                    QuickLink.quickSortll(ql.head, ql.tail);
                    t_temp = System.nanoTime() - t_Start;
                    linkedSum += t_temp;
                    if(t_temp < linkedMin) linkedMin    = t_temp;
                    if(t_temp > linkedMax) linkedMax = t_temp;
                }
                System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\n",n, arraySum/1000, arrayMin, arrayMax, linkedSum/1000, linkedMin, linkedMax);
            }
        }
    }

