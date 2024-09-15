package com.sparta.code.level1;

public class Solution35 {
    
    public static int solution(int n) {
        int answer = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans += 1;
            }
            n /= 2;
        }
        return answer;
    }
    
}
