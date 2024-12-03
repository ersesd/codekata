package com.sparta.code.level3;

class Solution14 {
    
    public int[][] solution(int n) {
        int[][] spiral = new int[n][n];
        int value = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (value <= n * n) {
            for (int i = left; i <= right; i++) {
                spiral[top][i] = value++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                spiral[i][right] = value++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                spiral[bottom][i] = value++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                spiral[i][left] = value++;
            }
            left++;
        }

        return spiral;
    }

    public long maxPulsedSubsequenceSum(int[] sequence) {
        long maxSum = Long.MIN_VALUE;
        long pulse1 = 0;
        long pulse2 = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            pulse1 = Math.max(sequence[i] * sign, pulse1 + sequence[i] * sign);
            pulse2 = Math.max(sequence[i] * -sign, pulse2 + sequence[i] * -sign);
            maxSum = Math.max(maxSum, Math.max(pulse1, pulse2));
        }
        
        return maxSum;
    }

    public long solution(int[] sequence) {
        return maxPulsedSubsequenceSum(sequence);
    }
    
}
