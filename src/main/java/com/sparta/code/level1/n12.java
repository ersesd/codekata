package com.sparta.code.level1;

class n12 {
    public double solution(int[] arr) {
        double answer = 0;
        if(arr.length >= 1 && arr.length <= 100){
            double total = 0;
            for(int num : arr){
                total += (double)num;
                answer = total / arr.length;
            }
        }
        return answer;
    }
}