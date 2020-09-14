package com.concepts;

import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        testMethod();

        try (Scanner sc = new Scanner(System.in)) {
            int numberOfTestCases = sc.nextInt();
            for (int i = 1; i <= numberOfTestCases; i++) {
                int[] coins = new int[sc.nextInt()];
                for (int j = 0; j < coins.length; j++) {
                    coins[j] = sc.nextInt();
                }
                int amount = sc.nextInt();
                System.out.println(coinChangeCount(coins, amount));
            }
        }
    }

    private static void testMethod() {
        int[] coins = { 2, 5, 3, 6 };
        int amount = 10;
        System.out.println(coinChangeCount(coins, amount));

        coins = new int[] { 1, 2, 3 };
        amount = 4;
        System.out.println(coinChangeCount(coins, amount));

        coins = new int[] { 168, 35, 101, 270, 125, 79, 259, 263, 165, 6, 246, 182, 28, 62, 192,
                296, 243, 28, 37, 292, 205, 3, 154, 293, 83, 22, 117, 219, 96, 48, 127, 72, 139, 70,
                113, 168, 200, 236, 295, 204, 112, 123 };

        coins = new int[] { 6, 28, 28, 3, 22 };
        amount = 34;
        System.out.println(coinChangeCount(coins, amount));

        coins = new int[] { 3, 6, 22, 28 };
        amount = 34;
        System.out.println(coinChangeCount(coins, amount));
    }

    private static int coinChangeCount(int[] coins, int amount) {
        // Arrays.sort(coins);
        int[] ways = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int amt = 1; amt <= amount; amt++) {
                if (coins[i] == amt) {
                    ways[coins[i]] += 1;
                }
                else if (coins[i] < amt) {
                    ways[amt] += ways[amt - coins[i]];
                }
            }
        }
        return ways[amount];
    }

}
