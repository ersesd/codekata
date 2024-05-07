package com.sparta.code.level1;

class Solution14 {
    
    public int solution(int[] number) {
        int cnt = 0;
        
        for (int i = 0; i < number.length-2; i++){
            for (int j = i+1; j < number.length-1; j++){
                for (int k = j+1; k < number.length; k ++){
                    if(number[i] + number[j] + number[k] == 0){
                        cnt +=1;
                    }
                }
            }
        }
        
        return cnt;
    }

}
