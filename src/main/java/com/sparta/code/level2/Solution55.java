package com.sparta.code.level2;

class Solution55 {
    
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] numbers = {"4", "1", "2"};

        while (n > 0) {
            int num = n % 3;

            if (num == 0) {
                n--;
            }

            answer.insert(0, numbers[num]);
            n /= 3;
        }

        return answer.toString(); 
    }
    
}
