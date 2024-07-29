package com.sparta.code.level2;

import java.util.*;

class Solution25 {
    
    public int solution(String[][] book_time) {
        int answer = 0;

        // 예약 시간을 시작 시간 기준으로 정렬
        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));

        // 종료 시간을 관리하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

        for (String[] book : book_time) {
            // 시작 시간과 종료 시간을 분 단위로 변환
            int start = convertToMinutes(book[0]);
            int end = convertToMinutes(book[1]) + 10;

            // 우선순위 큐가 비어 있는 경우 새로운 방 추가
            if (pq.isEmpty()) {
                answer++;
                pq.offer(new int[]{start, end});
                continue;
            }

            // 이전 예약의 종료 시간을 확인
            int[] prev = pq.poll();
            int prevEnd = prev[1];

            // 현재 예약이 이전 예약의 종료 시간 이후인 경우
            if (start >= prevEnd) {
                pq.offer(new int[]{start, end});
            } else {
                answer++;
                pq.offer(new int[]{start, end});
                pq.offer(prev);
            }
        }

        return answer;
    }

    // 시간을 분으로 변환하는 메소드
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
}
