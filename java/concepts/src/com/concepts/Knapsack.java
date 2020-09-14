package com.concepts;

import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        testMethod();

        try (Scanner sc = new Scanner(System.in)) {
            int numberOfTestCases = sc.nextInt();
            for (int i = 1; i <= numberOfTestCases; i++) {
                int[] weights = new int[sc.nextInt()];
                int[] values = new int[weights.length];
                int capacity = sc.nextInt();
                for (int j = 0; j < values.length; j++) {
                    values[j] = sc.nextInt();
                }
                for (int j = 0; j < weights.length; j++) {
                    weights[j] = sc.nextInt();
                }
                System.out.println(getMaxValue(values, weights, capacity));
            }
        }
    }

    private static void testMethod() {
        int[] values = { 1, 2, 3 };
        int[] weights = { 4, 5, 1 };
        int maxWeight = 4;
        System.out.println(getMaxValue(values, weights, maxWeight));

        values = new int[] { 6, 10, 12 };
        weights = new int[] { 1, 2, 3 };
        maxWeight = 5;
        System.out.println(getMaxValue(values, weights, maxWeight));
    }

    private static int getMaxValue(int[] values, int[] weights, int capacity) {
        int[] maxValue = new int[capacity + 1];
        for (int i = 0; i < values.length; i++) {
            for (int w = capacity; w > 0; w--) {
                if (weights[i] <= w) {
                    maxValue[w] = Math.max(maxValue[w], maxValue[w - weights[i]] + values[i]);
                }
            }
        }
        return maxValue[capacity];
    }
}
