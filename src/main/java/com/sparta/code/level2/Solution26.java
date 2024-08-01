package com.sparta.code.level2;

import java.util.*;

class Solution26 {
    
    public int solution(int[] elements) {
        int n = elements.length;
        int[] newElements = new int[n * 2];

        for (int i = 0; i < n; i++) {
            newElements[i] = elements[i];
            newElements[i + n] = elements[i];
        }

        // 중복을 제거하기 위한 셋
        Set<Integer> set = new HashSet<>();

        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                // 부분 수열의 합 계산
                for (int k = 0; k < length; k++) {
                    sum += newElements[start + k];
                }
                set.add(sum);
            }
        }

        // 개수 반환
        return set.size();
    }
    
}
