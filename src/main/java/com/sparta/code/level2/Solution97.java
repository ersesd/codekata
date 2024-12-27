package com.sparta.code.level2;

import java.util.*;

class Solution97 {
    
    public String solution(String p) {
        // 이미 올바른 괄호 문자열인지 확인
        if (isCorrect(p)) {
            return p;
        }
        return process(p);
    }

    private String process(String w) {
        if (w.isEmpty()) {
            return "";
        }

        // u와 v로 분리
        int index = splitIndex(w);
        String u = w.substring(0, index);
        String v = w.substring(index);

        if (isCorrect(u)) {
            // u가 올바른 괄호 문자열이라면 v를 재귀 처리
            return u + process(v);
        } else {
            // u가 올바르지 않은 경우
            String sb = "(" +
                    process(v) +
                    ")" +
                    reverse(u.substring(1, u.length() - 1));
            return sb;
        }
    }

    private int splitIndex(String w) {
        int balance = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                return i + 1;
            }
        }
        return w.length();
    }

    private boolean isCorrect(String w) {
        Stack<Character> stack = new Stack<>();
        for (char c : w.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (char c : u.toCharArray()) {
            if (c == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution97 sol = new Solution97();

        // 테스트 케이스
        System.out.println(sol.solution("(()())()")); // "(()())()"
        System.out.println(sol.solution(")(")); // "()"
        System.out.println(sol.solution("()))((()")); // "()(())()"
    }
    
}
