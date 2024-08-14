package com.sparta.code.level2;

class Solution32 {
    
    boolean solution(String s) {
        int count = 0;

        for (char item : s.toCharArray()) {
            if (item == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false; // 괄호가 올바르지 않은 경우
                }
                count--;
            }
        }

        return count == 0; // 모든 괄호가 올바르면 true
    }
    
}
