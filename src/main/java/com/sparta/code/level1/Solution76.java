package com.sparta.code.level1;

import java.util.Arrays;

class Solution76 {
    
    public int solution(int[][] targets) {
        // 폭격 미사일을 끝점(e) 기준으로 오름차순 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int prevEnd = -1; // 이전 요격 미사일의 끝점
        
        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];
            
            // 현재 미사일의 시작점이 이전 요격 위치보다 크거나 같으면 새로운 요격 필요
            if (s >= prevEnd) {
                count++;
                prevEnd = e; // 요격 위치를 현재 미사일의 끝점으로 갱신
            }
        }
        
        return count;
    }
    
}
