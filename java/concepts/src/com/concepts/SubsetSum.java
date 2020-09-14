package com.concepts;

import java.util.Scanner;

public class SubsetSum {

    public static void main(String[] args) {
        testMethod();

        // readInput();
    }

    private static void readInput() {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfTestCases = sc.nextInt();
            for (int i = 1; i <= numberOfTestCases; i++) {
                int[] input = new int[sc.nextInt()];
                for (int j = 0; j < input.length; j++) {
                    input[j] = sc.nextInt();
                }
                System.out.println(solve(input));
            }
        }
    }

    private static void testMethod() {
        int[] input = { 1, 5, 11, 5 };
        System.out.println(solve(input));

        input = new int[] { 87, 56, 43, 91, 27, 65, 59, 36, 32, 51, 37, 28, 75, 7, 74 };
        System.out.println(solve(input));

        input = new int[] { 478, 757, 314, 471, 729, 100, 459, 618 };
        System.out.println(solve(input));

        input = new int[] { 1, 3, 5 };
        System.out.println(solve(input));

    }

    private static boolean solve(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[] sums = new boolean[sum + 1];
        for (int i = 0; i < input.length; i++) {
            for (int j = sum; j > 0; j--) {
                if (j == input[i]) {
                    sums[j] = true;
                }
                if (j > input[i]) {
                    sums[j] = sums[j] || sums[j - input[i]];
                }
            }
        }
        return sums[sum];
    }

}
