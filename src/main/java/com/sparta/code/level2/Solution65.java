package com.sparta.code.level2;

import java.util.*;

class Solution65 {
    
    private static final List<int[]> arr = new ArrayList<>(); // 이동 경로를 저장할 리스트

    public int[][] solution(int n) {
        move(n, 1, 2, 3); // 하노이 탑 이동 시작
        int[][] answer = arr.stream()
                .toArray(int[][]::new); // 리스트를 2차원 배열로 변환
        return answer; // 결과 반환
    }

    // 하노이 탑 이동을 수행하는 재귀 함수
    private static void move(int cnt, int start, int mid, int end) {
        if (cnt == 0) {
            return; // 이동할 원반이 없으면 종료
        }
        // n-1개의 원반을 중간 기둥으로 이동
        move(cnt - 1, start, end, mid);
        arr.add(new int[]{start, end}); // 가장 큰 원반을 목표 기둥으로 이동
        // n-1개의 원반을 목표 기둥으로 이동
        move(cnt - 1, mid, start, end);
    }
    
}
