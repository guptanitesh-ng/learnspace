package com.concepts;

import java.util.Scanner;

public class MinimumJumps {

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
                System.out.println(getMinimumJumps(input));
            }
        }
    }

    private static void testMethod() {
        int[] input = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        // System.out.println(getMinimumJumps(input));

        input = new int[] { 2, 5, 3, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println(getMinimumJumps(input));

        input = new int[] { 2, 1, 0, 3 };
        System.out.println(getMinimumJumps(input));

        input = new int[] { 4, 2, 5, 7, 9, 4, 57, 6, 89, 9, 4, 76, 57, 2 };
        System.out.println(getMinimumJumps(input));

        input = new int[] { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
        System.out.println(getMinimumJumps(input));
    }

    private static int getMinimumJumps(int[] input) {
        if (input[0] == 0) {
            return -1;
        }
        int jumps = 0;
        int maxReach = 0;
        int allowedSteps = 1;
        int possibleSteps = 0;
        for (int i = 0; i < input.length; i++) {
            allowedSteps--;
            possibleSteps--;
            if (i + input[i] > maxReach) {
                maxReach = i + input[i];
                possibleSteps = input[i];
            }
            if (maxReach >= input.length - 1) {
                return jumps + 1;
            }
            if (maxReach <= i) {
                return -1;
            }
            if (allowedSteps == 0) {
                jumps++;
                // maxReach = 0;
                allowedSteps = possibleSteps;
            }
        }
        return jumps;
    }
}
