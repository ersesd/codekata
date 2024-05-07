package com.sparta.code.level1;

class Solution15 {
    public int solution(String t, String p) {
        int answer = 0;
        Long numberOfP = Long.valueOf(p);
            
        for(int i=0; i<= t.length()-p.length(); i++){
            String temp = t.substring(i, i+p.length());
            Long numberOfTemp = Long.valueOf(temp);
          if (numberOfTemp <= numberOfP) {
            answer++;
          }
        }
         
        return answer;
    }
}
