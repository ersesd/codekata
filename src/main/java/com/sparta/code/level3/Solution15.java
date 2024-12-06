package com.sparta.code.level3;

import java.util.*;

class Solution15 {
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

    public int diskController(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0;
        int index = 0;
        int totalWaitTime = 0;
        
        while (index < jobs.length || !pq.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index++]);
            }
            
            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                totalWaitTime += time - job[0];
            }
        }
        
        return totalWaitTime / jobs.length;
    }
}