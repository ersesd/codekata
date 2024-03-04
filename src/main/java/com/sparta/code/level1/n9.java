package com.sparta.code.level1;

class n9 {
    public int solution(int n) {
        int answer = 0;
        int total = 0;
        for(int i = 0; i <= n; i++){
            if(i % 2 == 0){
                total += i;
            }
            answer = total;
        }
        return answer;
    }
}