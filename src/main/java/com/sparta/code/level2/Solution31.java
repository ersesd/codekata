package com.sparta.code.level2;

import java.util.HashMap;
import java.util.Map;

class Solution31 {
    
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        // 전화번호를 해시맵에 저장
        for (String number : phone_book) {
            map.put(number, 1);
        }

        // 각 전화번호의 접두어 검사
        for (String number : phone_book) {
            for (int j = 1; j < number.length(); j++) {
                if (map.containsKey(number.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
    
}
