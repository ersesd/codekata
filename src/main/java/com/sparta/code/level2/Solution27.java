package com.sparta.code.level2;

class Solution27 {
    
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int remainder = storey % 10;
            int quotient = storey / 10;

            if (remainder > 5 || (remainder == 5 && quotient % 10 >= 5)) {
                answer += (10 - remainder);
                storey = quotient + 1;  // 자리 올림
            } else {
                answer += remainder;
                storey = quotient;
            }
        }
        
        return answer;
    }
    
}
