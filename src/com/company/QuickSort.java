package com.company;

public class QuickSort {

    public static void quickSort(int[] array, int lo, int hi){

        if(lo < hi){
            int pi = partition(array, lo, hi);
            quickSort(array, lo, pi-1);
            quickSort(array, pi+1, hi);
        }
    }

    public static int partition(int[] array, int lo, int hi){

        int pivot = array[hi];
        int i = (lo-1);

        for (int j = lo; j <= hi-1; j++) {
            if(array[j] < pivot){
                i++;
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }
        int swap = array[i+1];
        array[i+1] = array[hi];
        array[hi] = swap;
        return (i+1);
    }
}
