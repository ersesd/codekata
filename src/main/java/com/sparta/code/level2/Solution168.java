package com.sparta.code.level2;

public class Solution168 {
    
    public int solution(int[] players, int m, int k) {
        int N = 24;                   
        int diffSize = N + k;          
        int[] diff = new int[diffSize];
        
        int active = 0;                // 서버 개수
        int totalInstalls = 0;         // 설치 횟수
        
        // 0시부터 23시까지 각 시간대에 대해 시뮬레이션
        for (int hour = 0; hour < N; hour++) {
            active += diff[hour];      // 이전에 증설되어 아직 운영 중인 서버들을 반영
            
            // 해당 시간대에 필요한 최소 서버 수 (players[hour]가 m명 미만이면 0, 그렇지 않으면 정수 나눗셈 결과)
            int required = players[hour] / m;
            
            // 현재 활성화된 서버가 부족하면 추가 증설해야 함
            if (active < required) {
                int add = required - active;
                totalInstalls += add;
                active += add;
                
                if (hour + k < diffSize) {
                    diff[hour + k] -= add;
                }
            }
        }
        
        return totalInstalls;
    }
    
}
