package com.sparta.code.level2;

class Solution53 {
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();  // 결과 저장
        StringBuilder temp = new StringBuilder();    // 모든 숫자 저장
        
        // N진수로 변환하여 저장
        for (int i = 0; temp.length() < t * m; i++) {
            temp.append(Integer.toString(i, n));
        }
        
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(temp.charAt(i));
        }
        
        // 대문자로 반환
        return answer.toString().toUpperCase();
    }
    
}
