package com.sparta.code.level2;

import java.util.*;

class Solution83 {
    
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = Arrays.stream(queue2).asLongStream().sum();
        long targetSum = (sum1 + sum2) / 2;
        if ((sum1 + sum2) % 2 != 0) return -1;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : queue1) q1.add(num);
        for (int num : queue2) q2.add(num);
        
        int maxOperations = queue1.length * 3;
        int operations = 0;
        
        while (operations < maxOperations) {
            if (sum1 == targetSum) return operations;
            if (sum1 > targetSum) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
            operations++;
        }
        
        return -1;
    }
    
}
