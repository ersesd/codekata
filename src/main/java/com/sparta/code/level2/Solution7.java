package com.sparta.code.level2;

class Solution7 {
    
    private static final String[] DAYS_OF_WEEK = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    private static final int[] DAYS_IN_MONTHS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public String solution(int month, int day) {
        int totalDays = calculateDaysFromStartOfYear(month, day);
        return getDayOfWeek(totalDays);
    }

    private int calculateDaysFromStartOfYear(int month, int day) {
        int daysSum = 0;
        for (int i = 0; i < month - 1; i++) {
            daysSum += DAYS_IN_MONTHS[i];
        }
        daysSum += day - 1;  
        return daysSum;
    }

    private String getDayOfWeek(int totalDays) {
        return DAYS_OF_WEEK[totalDays % 7];
    }
    
}