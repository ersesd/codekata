package com.sparta.code.level1;

class n1 {
    public int solution(int num1, int num2) {
                int answer = 0;
        
        if((-50000 <= num1 && 50000 >= num2) && (-50000 <= num2 && 50000 >= num2)){
        int result = num1 - num2;
        answer = result;
        }
        return answer;
    }
}