package com.sparta.code.level2;

class Solution29 {
    
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int originalLength = s.length();
            s = s.replace("0", "");
            int newLength = s.length();

            answer[1] += (originalLength - newLength);
            
            s = Integer.toBinaryString(newLength);
            answer[0]++;
        }
        
        return answer;
    }
    
}
