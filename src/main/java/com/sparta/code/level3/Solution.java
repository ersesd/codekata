package com.sparta.code.level3;

import java.util.*;

public class Solution {
    
    public String solution(String m, String[] musicinfos) {
        String convertedM = convert(m);
        String answer = "(None)";
        int maxPlayTime = 0;
        
        // 각 음악 정보 처리
        for (String info : musicinfos) {
            // info 형식: "시작시각,종료시각,제목,악보"
            String[] parts = info.split(",");
            int start = convertTime(parts[0]);
            int end = convertTime(parts[1]);
            int playTime = end - start;
            String title = parts[2];
            String melody = convert(parts[3]);
            
            // 재생시간만큼 악보를 반복하거나 자름.
            String playedMelody = getPlayedMelody(melody, playTime);
            
            // 변환된 m이 재생된 악보에 포함되어 있다면 후보로 고려
            if (playedMelody.contains(convertedM)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        
        return answer;
    }
    
    // 악보 내의 "#"(샤프)를 소문자로 치환하여 단일 문자로 표현
    private String convert(String s) {
        s = s.replace("C#", "c");
        s = s.replace("D#", "d");
        s = s.replace("F#", "f");
        s = s.replace("G#", "g");
        s = s.replace("A#", "a");
        return s;
    }
    
    // "HH:MM" 형식의 시각을 분으로 변환
    private int convertTime(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
    
    // 주어진 악보(melody)를 playTime 길이에 맞게 반복 혹은 자른 재생 악보 생성
    private String getPlayedMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }
        return sb.toString();
    }
    
    // 테스트용 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(sol.solution(m1, musicinfos1));
        
        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(sol.solution(m2, musicinfos2)); 
        
        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(sol.solution(m3, musicinfos3)); 
    }
    
}
