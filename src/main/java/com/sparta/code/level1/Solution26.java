package com.sparta.code.level1;

class Solution26 {
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for(int i = 1; i < answer.length; i++){
            char ch = s.charAt(i);
            for(int j = i-1; j >= 0; j--){
                char c = s.charAt(j);
                if(c == ch){
                    answer[i] = i-j;
                    break;
                }
                if(j == 0){
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
        
    }
    
}
