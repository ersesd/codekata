package com.sparta.code.level2;

class Solution23 {
    
    public String solution(String number, int k) {
        StringBuilder answerBuilder = new StringBuilder();
        
        int len = number.length() - k; // 결과의 길이
        int start = 0;

        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    start = j + 1;
                }
            }
            // 가장 큰 문자를 결과에 추가
            answerBuilder.append(max);
        }
        
        return answerBuilder.toString();
        
    }
    
}
