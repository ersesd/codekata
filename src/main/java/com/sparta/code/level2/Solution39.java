package com.sparta.code.level2;

import java.util.ArrayList;
import java.util.List;

class Solution39 {
    
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};  // 규칙을 어긴 사람이 없을 때 기본값을 반환

        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (list.contains(words[i]) || !isConnected(list.get(list.size() - 1), words[i])) {
                answer[0] = i % n + 1;   // 사람 번호 계산
                answer[1] = i / n + 1;   // 차례 계산
                break;
            }
            list.add(words[i]);
        }

        return answer;
    }

    // 두 단어가 연결되는지 확인
    public boolean isConnected(String word1, String word2) {
        return word1.charAt(word1.length() - 1) == word2.charAt(0);
    }
    
}
