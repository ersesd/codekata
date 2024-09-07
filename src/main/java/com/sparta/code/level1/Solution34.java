package com.sparta.code.level1;

class Solution34 {
    
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // 대문자 범위 내에서 순환
                c = (char) ((c - 'A' + n) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                // 소문자 범위 내에서 순환
                c = (char) ((c - 'a' + n) % 26 + 'a');
            }
            answer.append(c);
        }

        return answer.toString();
    }
    
}
