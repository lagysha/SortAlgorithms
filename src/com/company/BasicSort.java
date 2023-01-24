package com.company;

import java.util.Arrays;

public class BasicSort extends  Printarray {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0 ; j < array.length - i -1; j++) {
                if(array[j] > array[j+1])
                {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array)
    {
        for(int i = 1;i<array.length;i++){
            int key = array[i];
            int j = i - 1;
            while(j>=0 && key < array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }

    }
    public static void selectionSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

}
