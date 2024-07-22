package com.sparta.code.level1;

import java.util.*;

class Solution23 {
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        
        // 맵에 저장
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        // 점수를 저장할 배열 생성
        int[] answer = new int[photo.length];
        
        // 각 사진을 순회
        for (int i = 0; i < photo.length; i++) {
            String[] persons = photo[i]; 
            int score = 0;
            
            for (String person : persons) {
                if (map.containsKey(person)) { 
                    score += map.get(person); 
                }
            }
            
            // 점수를 결과 배열에 저장
            answer[i] = score;
        }
        
        return answer;
    }
    
}
