package com.concepts;

import java.util.Arrays;

public class Josephus {

    public static void main(String[] args) {

        System.out.println(solution(3, 2));

        System.out.println(solution(5, 3));

        System.out.println(solution(10, 8));

        System.out.println(solution(20, 22));

        System.out.println(solution(1, 1));

        System.out.println(solution(20, 1));

        System.out.println(solution(8, 2));

        System.out.println(solution(17, 16));

    }

    private static int solution(int n, int k) {
        if (n == 1) {
            return 1;
        }
        boolean[] positionsStatus = new boolean[n];
        Arrays.fill(positionsStatus, true);
        apply(positionsStatus, k, n, 0);
        int safePosition = -1;
        for (int i = 0; i < n; i++) {
            if (positionsStatus[i]) {
                safePosition = i + 1;

            }
        }
        return safePosition;
    }

    private static void apply(boolean[] positionsStatus, int eliminatePosition,
            int availablePosition, int counter) {
        for (int i = 0; i < positionsStatus.length; i++) {
            if (positionsStatus[i]) {
                if (counter + 1 == eliminatePosition) {
                    positionsStatus[i] = false;
                    counter = 0;
                    availablePosition--;
                }
                else {
                    counter++;
                }
            }

            if (availablePosition == 1) {
                return;
            }
        }

        apply(positionsStatus, eliminatePosition, availablePosition, counter);

    }
}
