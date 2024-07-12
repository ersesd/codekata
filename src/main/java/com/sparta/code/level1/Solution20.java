package com.sparta.code.level1;

import java.util.*;

class Solution20 {
    
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // 귤 사이즈 개수 확인
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }
        
        // 내림차순 정렬
        List<Integer> sortedCounts = new ArrayList<>(countMap.values());
        sortedCounts.sort(Collections.reverseOrder());
        
        // 상자에 귤 담기
        int answer = 0;
        for (int count : sortedCounts) {
            if (k <= 0) break;
            k -= count;
            answer++;
        }
        
        return answer;
        
    }
    
}