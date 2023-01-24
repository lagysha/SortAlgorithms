package com.company;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {

    //ConcurrencySort is better than Basic ones approximately at 20_000 elements

    //ConcurrencySort is better than Efficient ones approximately at 10_000_000 elements
    public static void main(String[] args) {
        HashMap<Double,String > nums = new HashMap<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] numbers  = new int[number];
        ////////////////////////////////////////////////
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length);
        }
        //System.out.println(Arrays.toString(numbers));
        long m1 = System.nanoTime();
        EfficientSort.mergeSort(numbers);
        long n1 = System.nanoTime();
        //System.out.println(Arrays.toString(numbers));
        double num1 = (double)(n1-m1)/1000000;
        /////////////////////////////////////////////////
        ////////////////////////////////////////////////
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length);
        }
       // System.out.println(Arrays.toString(numbers));
        long m2 = System.nanoTime();
        EfficientSort.quickSort(numbers);
        long n2 = System.nanoTime();
        //System.out.println(Arrays.toString(numbers));
        double num2 = (double)(n2-m2)/1000000;
        /////////////////////////////////////////////////
        ////////////////////////////////////////////////
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length);
        }
        //System.out.println(Arrays.toString(numbers));
        long m3 = System.nanoTime();
        //BasicSort.bubbleSort(numbers);
        long n3 = System.nanoTime();
       // System.out.println(Arrays.toString(numbers));
        double num3 = (double)(n3-m3)/1000000;
        /////////////////////////////////////////////////
        ////////////////////////////////////////////////
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length);
        }
       // System.out.println(Arrays.toString(numbers));
        long m4 = System.nanoTime();
       //BasicSort.insertionSort(numbers);
        long n4 = System.nanoTime();
        //System.out.println(Arrays.toString(numbers));
        System.out.println();
        double num4 = (double)(n4-m4)/1000000;
        /////////////////////////////////////////////////
        ////////////////////////////////////////////////
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length);
        }
        //System.out.println(Arrays.toString(numbers));
        long m5 = System.nanoTime();
       //BasicSort.selectionSort(numbers);
        long n5 = System.nanoTime();
       //System.out.println(Arrays.toString(numbers));
        double num5 = (double)(n5-m5)/1000000;
        /////////////////////////////////////////////////
        ////////////////////////////////////////////////
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length);
        }
        //System.out.println(Arrays.toString(numbers));
        long m6 = System.nanoTime();
        ForkJoinPool.commonPool().invoke(new MergeSortTask(numbers));
        long n6 = System.nanoTime();
        //System.out.println(Arrays.toString(numbers));
        double num6 = (double)(n6-m6)/1000000;
        /////////////////////////////////////////////////
        nums.put(num1,"MergeSort");
        nums.put(num2,"QuickSort");
        nums.put(num3,"BubbleSort");
        nums.put(num4,"InsertionSort");
        nums.put(num5,"SelectionSort");
        nums.put(num6,"ConcurrencyMergeSort");
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(num1);
        arrayList.add(num2);
        arrayList.add(num3);
        arrayList.add(num4);
        arrayList.add(num5);
        arrayList.add(num6);
        arrayList.sort(Comparator.naturalOrder());
        System.out.println("Top time for sorting " + number + " elements");
        System.out.println("1:" + nums.get(arrayList.get(0)) + "Time: " + arrayList.get(0));
        System.out.println("2:" + nums.get(arrayList.get(1)) + "Time: " + arrayList.get(1));
        System.out.println("3:" + nums.get(arrayList.get(2)) + "Time: " + arrayList.get(2));
        System.out.println("4:" + nums.get(arrayList.get(3)) + "Time: " + arrayList.get(3));
        System.out.println("5:" + nums.get(arrayList.get(4)) + "Time: " + arrayList.get(4));
        System.out.println("6:" + nums.get(arrayList.get(5)) + "Time: " + arrayList.get(5));
    }
}
