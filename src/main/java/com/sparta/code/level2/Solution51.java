package com.sparta.code.level2;

import java.util.*;

class Solution51 {
    
    public String[] solution(String[] record) {
        List<String> answerList = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();

        // 닉네임 업데이트
        for (String r : record) {
            String[] strArr = r.split(" ");
            String command = strArr[0];
            String userId = strArr[1];

            if (command.equals("Enter") || command.equals("Change")) {
                hm.put(userId, strArr[2]);  // 닉네임 갱신
            }
        }

        // 메시지 생성
        for (String r : record) {
            String[] strArr = r.split(" ");
            String command = strArr[0];
            String userId = strArr[1];

            if (command.equals("Enter")) {
                answerList.add(hm.get(userId) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                answerList.add(hm.get(userId) + "님이 나갔습니다.");
            }
        }

        // 리스트를 배열로 변환 후 반환
        return answerList.toArray(new String[0]);
    }
    
}
