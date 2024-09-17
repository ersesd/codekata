package com.sparta.code.level1;

import java.util.Arrays;

class Solution36 {
    
    public int solution(int[] d, int budget) {
        int answer = 0;
        int totalSpent = 0;

        // 오름차순으로 정렬
        Arrays.sort(d);
        
        for (int cost : d) {
            totalSpent += cost; 
            
            if (totalSpent <= budget) {
                answer++;
            } else {
                break; 
            }
        }
        
        return answer;
    }
    
}
