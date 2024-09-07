package com.sparta.code.level2;

import java.util.Stack;

class Solution49 {
    
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();  // 문자가 같다면 제거
            } else {
                stack.push(ch);  // 아니면 스택 추가
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
    
}
