package com.company;

import java.util.Random;

public class EfficientSort extends Printarray{
    public static void mergeSort(int[] array)
    {
        int length = array.length;
        if(length < 2) return;
        int midIndex = length/2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[length - midIndex];
        for (int i = 0; i < midIndex ; i++) {
            leftArray[i] = array[i];
        }
        for (int i = midIndex; i < length; i++) {
            rightArray[i-midIndex] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array,leftArray,rightArray);
    }

    private static  void merge(int[] array , int[] leftArray , int[] rightArray)
    {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, j= 0, k =0;
        while(i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]){
                array[k] = leftArray[i];
                i++;
            }
            else{
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < leftSize){
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < rightSize){
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }
    public static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length-1);
    }
    public static void quickSort(int[] array, int low, int high){
        quickSortHelper(array, low, high);
    }
    private static void quickSortHelper(int[] array, int low, int high)
    {
        if(low >= high) return;

        int pivotIndex = new Random().nextInt(high-low)+low;
        swap(array,high,pivotIndex);
        int pivot = array[high];


        int leftPointer = partition(array,low,high,pivot);

        quickSortHelper(array,low,leftPointer-1);
        quickSortHelper(array,leftPointer+1,high);

    }
    private static int partition(int[] array, int low, int high, int pivot) {
        int leftPointer = low;
        int rightPointer = high;
        while(leftPointer < rightPointer){

            while(array[leftPointer] <= pivot && leftPointer < rightPointer) leftPointer++;
            while(array[rightPointer] >= pivot && leftPointer < rightPointer) rightPointer--;
            swap(array,leftPointer,rightPointer);
        }
        swap(array,leftPointer,high);

        return leftPointer;
    }
    private static void swap(int[] array, int leftPointer, int rightPointer) {
        int temp = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = temp;
    }
}
