package com.sparta.code.level2;

class Solution20 {
    // 각 자리에서의 기여도 계산
    private static final int[] placeValue = {781, 156, 31, 6, 1};
    private static final String characters = "AEIOU";
    
    public int solution(String word) {
        int answer = word.length();
        
        for (int i = 0; i < word.length(); i++) {
            int charIndex = characters.indexOf(word.charAt(i));
            answer += charIndex * placeValue[i];
        }
        
        return answer;
    }
    
}
