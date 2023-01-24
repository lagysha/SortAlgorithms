package com.company;

public class HeapSort extends  Printarray {
    public static int[] heapSort(int[] array) {
        if (array.length == 0)
            return array;
         // Строим кучу
        int length = array.length;
        // проходим от первого без ответвлений к корню
        for (int i = length / 2 - 1; i >= 0; i--)
            array = heapify(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            array = heapify(array, i, 0);
        }
        return array;
    }
    static int[] heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;
        // если левый дочерний больше родительского
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        // еслиправый дочерний больше родительского
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
       // если должна произойти замена
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            array = heapify(array, length, largest);//largest == index that part which we changed
        }
        return array;
     }
    }
