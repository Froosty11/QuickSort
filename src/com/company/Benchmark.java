package com.company;
import java.util.Random;

public class Benchmark {

    public static QuickLink rll(int n){
        QuickLink l = new QuickLink();
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            l.appendData(rd.nextInt(n*10));
        }
        return l;
    }

    public static int[] array(int n){
        int[] array = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = (rd.nextInt(n*10));
        }
        return array;
    }

    public static void benchmark(int iteration) {

        int[] nValues =
                {1000, 250, 500, 1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000, 128_000, 256_000};

        Random rd = new Random();


        for (int i = 0; i < nValues.length; i++) {
            int value = rd.nextInt(nValues[i]);
            long t = 0, t0, t1;
            for (int j = 0; j < iteration; j++) {

                Random random = new Random(100);

                int[] array = array(nValues[i]);
                QuickLink ls = rll(nValues[i]);

                t0 = System.nanoTime();

                 QuickSort.quickSort(array, 0, array.length-1);

                 //QuickLink.quickSortll(ls.head, ls.tail);

                t1 = System.nanoTime();
                t += t1 - t0;

            }
            System.out.println(nValues[i] + "\t" + t / iteration); //array nlogn nsquared worse nlogn average
        }

    }
}