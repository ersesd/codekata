package com.sparta.code.level2;

import java.util.*;

class Solution101 {
    
    public int solution(int[][] jobs) {
        // 작업 배열을 요청 시간 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // 소요 시간이 짧은 것 우선
            } else {
                return a[0] - b[0]; // 요청 시간이 빠른 것 우선
            }
        });

        int currentTime = 0;
        int totalWaitingTime = 0;
        int index = 0;

        while (index < jobs.length || !pq.isEmpty()) {
            // 현재 시간까지 요청된 작업들을 큐에 추가
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(jobs[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                // 큐에서 작업을 꺼내 처리
                int[] job = pq.poll();
                currentTime += job[1];
                totalWaitingTime += (currentTime - job[0]);
            } else {
                // 처리할 작업이 없다면 시간 진행
                currentTime = jobs[index][0];
            }
        }

        return totalWaitingTime / jobs.length;
    }

    public static void main(String[] args) {
        Solution101 sol = new Solution101();

        int[][] jobs1 = {
            {0, 3},
            {1, 9},
            {2, 6}
        };

        int[][] jobs2 = {
            {0, 5},
            {2, 2},
            {4, 3}
        };

        System.out.println(sol.solution(jobs1)); // 9
        System.out.println(sol.solution(jobs2)); // 5
    }
    
}
