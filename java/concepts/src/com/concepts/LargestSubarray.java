package com.concepts;

public class LargestSubarray {

    public static void main(String[] args) {
        int[] input = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(solve(input, input.length));
    }

    private static int solve(int[] arr, int n) {
        int largestSubarrayLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int elementCount = 1;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                elementCount++;
                if (sum == 0 && elementCount > largestSubarrayLength) {
                    largestSubarrayLength = elementCount;
                }
            }

        }
        return largestSubarrayLength;
    }
}