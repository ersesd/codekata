package com.sparta.code.level1;

class n6 {
    public int solution(int num1, int num2) {
        int result = 0;
        int answer = -1;
        if((num1 >= -50000 && num1 <= 50000)&&(num2 >= -50000 && num2 <= 50000)){
            result = num1 + num2;
            answer = result;
        } else {
            System.out.println("ss");
        }
        return answer;
    }
}