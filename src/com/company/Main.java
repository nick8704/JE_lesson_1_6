package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    static int[] array = new int[100];

    static {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    public static void main(String[] args) {
        System.out.printf("Min value of array is: %d\n", minValue(array));
        sortArray(array);
        mostOftenValue(array);
    }

    private static int minValue(int[] arrayOfIntegers) {
        int result = arrayOfIntegers[0];
        for (int i = 1; i < arrayOfIntegers.length; i++) {
            if(arrayOfIntegers[i] < result) {
                result = arrayOfIntegers[i];
            }
        }
        return result;
    }

    private static void sortArray(int[] arrayForSort) {
        Arrays.sort(arrayForSort);
        int[] newArray = new int[arrayForSort.length];
        for (int i = 0; i < arrayForSort.length; i++) {
            newArray[i] = arrayForSort[arrayForSort.length - 1 - i];
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
    }

    private static void mostOftenValue (int[] arrayOfIntegers) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < arrayOfIntegers.length; i++) {
            if(result.containsKey(arrayOfIntegers[i])) {
                result.put(arrayOfIntegers[i], result.get(arrayOfIntegers[i]) + 1);
            } else {
                result.put(arrayOfIntegers[i], 1);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry: result.entrySet()) {
            if(entry.getValue() > count) {
                count = entry.getValue();
            }
        }

        System.out.print("The most often values in an array is: ");
        for (Map.Entry<Integer, Integer> entry: result.entrySet()) {
            if(entry.getValue() == count) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}