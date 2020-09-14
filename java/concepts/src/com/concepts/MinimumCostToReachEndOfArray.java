package com.concepts;

public class MinimumCostToReachEndOfArray {

    public static void main(String[] args) {

        int[] input = { 10, 30, 40, 50, 20 };
        System.out.println(getMinimumCost(input, 3));

        input = new int[] { 40, 10, 20, 70, 80, 10 };
        System.out.println(getMinimumCost(input, 4));
    }

    private static int getMinimumCost(int[] input, int k) {
        int[] cost = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j <= k && (i + j) < input.length; j++) {
                int difference = cost[i] + getDifference(input[i], input[i + j]);
                if (cost[i + j] == 0 || cost[i + j] > difference) {
                    cost[i + j] = difference;
                }
            }
        }
        return cost[input.length - 1];
    }

    private static int getDifference(int i, int j) {
        return Math.abs(i - j);
    }
}
