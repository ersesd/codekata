package com.sparta.code.level1;

class Solution29 {
    
    public int solution(int n) {
        // 3진수로 변환 후 리버스
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        sb.reverse();

        // 리버스된 3진수를 10진수로 변환
        int answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }
    
}
