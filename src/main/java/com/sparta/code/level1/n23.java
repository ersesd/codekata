package com.sparta.code.level1;

import java.util.*;

class n23 {
    
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantCount = new HashMap<>();
        
        // 참가자 명단에 이름을 저장하고 카운트 증가
        for (String name : participant) {
            participantCount.put(name, participantCount.getOrDefault(name, 0) + 1);
        }
        
        // 완주자 명단에 이름이 있으면 카운트 감소
        for (String name : completion) {
            participantCount.put(name, participantCount.get(name) - 1);
        }
        
        // 카운트가 0이 아닌 이름을 찾음 (완주하지 못한 선수)
        for (Map.Entry<String, Integer> entry : participantCount.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return ""; // 모든 선수가 완주한 경우는 없으므로 이 줄은 실행되지 않음
    }
    
}
