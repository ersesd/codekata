package com.sparta.code.level3;

import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, String[] timetable) {
        // 시간 계산을 위해 HH:MM 형식을 분 단위로 변환
        int[] times = Arrays.stream(timetable)
                .mapToInt(this::convertToMinutes)
                .sorted()
                .toArray();

        int shuttleTime = convertToMinutes("09:00"); // 첫 셔틀 시간
        int lastCrewTime = 0; // 콘이 탈 수 있는 가장 늦은 시간
        int idx = 0; // 대기열에서 현재 크루의 인덱스

        for (int i = 0; i < n; i++) {
            int capacity = m; // 현재 셔틀의 남은 좌석 수
            while (idx < times.length && times[idx] <= shuttleTime && capacity > 0) {
                lastCrewTime = times[idx];
                idx++;
                capacity--;
            }

            // 마지막 셔틀일 때 콘이 탈 수 있는 시간 결정
            if (i == n - 1) {
                if (capacity > 0) {
                    // 자리가 남아있으면 셔틀 시간에 탈 수 있음
                    return convertToHHMM(shuttleTime);
                } else {
                    // 자리가 없으면 마지막 크루보다 1분 먼저 도착해야 함
                    return convertToHHMM(lastCrewTime - 1);
                }
            }

            // 다음 셔틀 시간으로 갱신
            shuttleTime += t;
        }

        return "";
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String convertToHHMM(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"})); // "09:00"
        System.out.println(sol.solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"})); // "09:09"
        System.out.println(sol.solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"})); // "08:59"
        System.out.println(sol.solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"})); // "00:00"
        System.out.println(sol.solution(1, 1, 1, new String[]{"23:59"})); // "09:00"
    }
    
}
