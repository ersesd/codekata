package com.sparta.code.level1;

class n7 {
    public int solution(int num1, int num2) {
        double result = 0;
        int answer = 0;
        double num = 0;
        if((num1 >= 0 && num1 <= 100)&&(num2 >= 0 && num2 <= 100)){
            num =  (double)num1 / num2;
            result = num * 1000;
            answer = (int)result;
        } else {
            System.out.println("ss");
        }        
        return answer;
    }
}