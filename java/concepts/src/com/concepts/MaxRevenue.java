package com.concepts;

public class MaxRevenue {

    public static void main(String[] args) {
        int[] inputA = new int[] { 34, 49, 87, 67, 2, 5, 19 };
        System.out.println((maxRevenue(inputA)));
        inputA = new int[] { 6, 7, 1, 3, 8, 2, 4 };
        System.out.println((maxRevenue(inputA)));
        inputA = new int[] { 5, 3, 4, 11, 2 };
        System.out.println((maxRevenue(inputA)));
        inputA = new int[] { 3, 2, 7, 10 };
        System.out.println((maxRevenue(inputA)));
        inputA = new int[] { 5, 5, 10, 100, 10, 5 };
        System.out.println((maxRevenue(inputA)));
        inputA = new int[] { 100, 2, 3, 100, 4, 8, 100 };
        System.out.println((maxRevenue(inputA)));

        inputA = new int[] { 5, 5, 10, 100, 10, 5 };
        System.out.println((maxRevenue(inputA)));
    }

    public static int maxRevenue(int[] budgets) {
        int[] maxRevenue = new int[budgets.length];
        maxRevenue[0] = budgets[0];
        maxRevenue[1] = Math.max(budgets[0], budgets[1]);
        for (int i = 2; i < budgets.length; i++) {
            maxRevenue[i] = Math.max(budgets[i] + maxRevenue[i - 2], maxRevenue[i - 1]);
        }
        return maxRevenue[budgets.length - 1];
    }

}