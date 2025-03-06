package com.sparta.code.level1;

public class Solution {
    
    public int solution(int[] schedules, int[][] timelogs, int startDay) {
        int count = 0;
        int n = schedules.length;
        
        for (int i = 0; i < n; i++) {
            int schedule = schedules[i];
            int hours = schedule / 100;
            int minutes = schedule % 100;
            int totalMinutes = hours * 60 + minutes + 10;
            int maxTime = (totalMinutes / 60) * 100 + (totalMinutes % 60);
            
            boolean isValid = true;
            for (int j = 0; j < 7; j++) {
                int dayOfWeek = ((startDay - 1) + j) % 7 + 1;
                if (dayOfWeek == 6 || dayOfWeek == 7) {
                    continue;
                }
                int logTime = timelogs[i][j];
                if (logTime > maxTime) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                count++;
            }
        }
        
        return count;
    }
    
}
