package com.sparta.code.level2;

import java.util.*;

class Solution73 {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // col번째 컬럼의 값을 기준으로 오름차순 정렬, 같은 값이면 첫 번째 컬럼의 내림차순 정렬
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return b[0] - a[0];
            } else {
                return a[col - 1] - b[col - 1];
            }
        });

        int hashValue = 0;

        // row_begin부터 row_end까지 각 행에 대해 나머지 합 계산 후 XOR 연산
        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int value : data[i - 1]) {
                sum += value % i; // 각 컬럼의 값을 i로 나눈 나머지를 더함
            }
            hashValue ^= sum; // XOR 연산
        }

        return hashValue;
    }
    
}
