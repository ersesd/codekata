package com.sparta.code.level2;

class Solution82 {
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int current = 1;
        
        for (int station : stations) {
            int left = station - w;
            if (current < left) {
                int gap = left - current;
                answer += (gap + coverage - 1) / coverage;
            }
            current = station + w + 1;
        }
        
        if (current <= n) {
            answer += (n - current + coverage) / coverage;
        }
        
        return answer;
    }
    
}
