package com.sparta.code.level1;

class n3 {
    public int solution(int num1, int num2) {
        int answer = 0;
        double result = 0;
        if((num1 > 0 && num1 <= 100) && (num2 > 0 && num2 <= 100)){
            result = num1 / num2;
            answer = (int)result;
        } else {
            System.out.println("잘못된 값입니다.");
        }
        return answer;
    }
}