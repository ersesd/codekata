package com.sparta.code.level1;

class Solution44 {
    
    public int solution(String[] babbling) {
        String[] validWords = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String word : babbling) {
            String original = word;
            for (String valid : validWords) {
                word = word.replace(valid, " "); // 발음 가능한 단어 제거
            }

            // 모든 단어가 제거되었고 공백만 남아야 함
            if (word.trim().isEmpty()) {
                count++;
            }
        }

        return count;
    }
    
}
