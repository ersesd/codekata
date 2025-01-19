package com.sparta.code.level3;

import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        m = replaceSharpNotes(m);
        String answer = "(None)";
        int longestDuration = 0;

        for (String info : musicinfos) {
            String[] details = info.split(",");
            String startTime = details[0];
            String endTime = details[1];
            String title = details[2];
            String sheet = replaceSharpNotes(details[3]);

            int duration = calculateDuration(startTime, endTime);

            String played = repeatSheet(sheet, duration);

            if (played.contains(m) && duration > longestDuration) {
                answer = title;
                longestDuration = duration;
            }
        }

        return answer;
    }

    private String replaceSharpNotes(String melody) {
        return melody.replace("C#", "c")
                     .replace("D#", "d")
                     .replace("F#", "f")
                     .replace("G#", "g")
                     .replace("A#", "a");
    }

    private int calculateDuration(String start, String end) {
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");

        int startHour = Integer.parseInt(startParts[0]);
        int startMinute = Integer.parseInt(startParts[1]);
        int endHour = Integer.parseInt(endParts[0]);
        int endMinute = Integer.parseInt(endParts[1]);

        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    }

    private String repeatSheet(String sheet, int duration) {
        StringBuilder played = new StringBuilder();
        for (int i = 0; i < duration; i++) {
            played.append(sheet.charAt(i % sheet.length()));
        }
        return played.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"})); // "HELLO"
        System.out.println(sol.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"})); // "FOO"
        System.out.println(sol.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"})); // "WORLD"
    }
    
}
