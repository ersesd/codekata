package com.sparta.code.level1;

class n11 {
    public String solution(int num) {
        String answer = "";
        if(num % 2 != 0) {
            answer = "Odd";
            
        } else if(num % 2 == 0){
            answer = "Even";
        }
        return answer;
    }
}