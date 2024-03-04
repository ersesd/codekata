package com.sparta.code.level1;

class n4 {
    public int solution(int age) {
        int answer = 0;
        int year = 2023;
        int birth = 0;
        
        if(age > 0 && 120 >= age) {
            birth = year - age;
            answer = birth;
        }
        
        
        return answer;
    }
}