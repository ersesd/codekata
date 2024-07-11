package com.sparta.code.level2;

import java.util.Arrays;

public class Solution16 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
        System.out.println(Arrays.toString(solution(4, 7, 14)));
    }

    public static int[] solution(int n, long left, long right) {
        int length = (int) (right - left) + 1;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = (int) Math.max(left / n, left % n) + 1;
            left++;
        }

        return answer;
        
    }
    
}