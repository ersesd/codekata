package com.sparta.code.level1;

import java.util.Arrays;

class Solution40 {
    
    public int solution(String dartResult) {
        int[] scores = new int[3];
        char[] arr = dartResult.toCharArray();
        int idx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1' && i + 1 < arr.length && arr[i + 1] == '0') {
                idx++;
                scores[idx] = 10;
                i++;
            } else if (Character.isDigit(arr[i])) {
                idx++;
                scores[idx] = arr[i] - '0';
            } else {
                switch (arr[i]) {
                    case 'D':
                        scores[idx] = (int) Math.pow(scores[idx], 2);
                        break;
                    case 'T':
                        scores[idx] = (int) Math.pow(scores[idx], 3);
                        break;
                    case '*':
                        scores[idx] *= 2;
                        if (idx > 0) scores[idx - 1] *= 2; 
                        break;
                    case '#':
                        scores[idx] *= -1; 
                        break;
                }
            }
        }

        return Arrays.stream(scores).sum(); 
    }
    
}
