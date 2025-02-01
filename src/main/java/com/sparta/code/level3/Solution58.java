package com.sparta.code.level3;

import java.util.*;

class Solution58 {
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 무한대 값 설정
        int INF = 100000000;

        // 플로이드-워셜을 위한 거리 배열 초기화
        int[][] dist = new int[n + 1][n + 1];

        // 모든 거리를 무한대로 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 요금 정보 입력
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            dist[c][d] = f;
            dist[d][c] = f;
        }

        // 플로이드-워셜 알고리즘 실행 (모든 노드 쌍 최단 거리 계산)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 최소 요금 계산
        int minFare = INF;

        // 모든 지점을 경유지로 고려하여 최소 요금 찾기
        for (int i = 1; i <= n; i++) {
            int totalFare = dist[s][i] + dist[i][a] + dist[i][b];
            minFare = Math.min(minFare, totalFare);
        }

        return minFare;
    }

    public static void main(String[] args) {
        Solution58 sol = new Solution58();
        int[][] fares1 = {
            {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41},
            {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
        };
        System.out.println(sol.solution(6, 4, 6, 2, fares1)); // 82

        int[][] fares2 = {
            {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}
        };
        System.out.println(sol.solution(7, 3, 4, 1, fares2)); // 14

        int[][] fares3 = {
            {2,6,6}, {6,3,7}, {4,6,7}, {6,5,11},
            {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}
        };
        System.out.println(sol.solution(6, 4, 5, 6, fares3)); // 18
    }
    
}
