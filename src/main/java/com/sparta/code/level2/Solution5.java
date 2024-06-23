package com.sparta.code.level2;

class Solution5 {
    
    public int solution5(int a, int b, int n) {
        
        int answer = 0;
        
        while (n / a >= 1) {
            answer += (n / a) * b;
            n = ((n / a) * b) + (n % a);
        }
        
        return answer;
    }
    
}