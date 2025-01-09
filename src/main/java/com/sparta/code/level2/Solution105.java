package com.sparta.code.level2;

import java.util.*;

class Solution105 {
    
    public String[] solution(String[] s) {
        String[] result = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            result[i] = rearrange(s[i]);
        }

        return result;
    }

    private String rearrange(String x) {
        Stack<Character> stack = new Stack<>();
        int count110 = 0;

        // "110"을 찾아 제거하고 개수 세기
        for (int i = 0; i < x.length(); i++) {
            stack.push(x.charAt(i));

            if (stack.size() >= 3) {
                char third = stack.pop();
                char second = stack.pop();
                char first = stack.pop();

                if (first == '1' && second == '1' && third == '0') {
                    count110++;
                } else {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                }
            }
        }

        // 스택에 남은 문자들 가져오기
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.insert(0, stack.pop());
        }

        // "110"을 적절한 위치에 삽입
        int insertPosition = findInsertPosition(remaining);
        StringBuilder result = new StringBuilder();
        result.append(remaining.substring(0, insertPosition));
        while (count110-- > 0) {
            result.append("110");
        }
        result.append(remaining.substring(insertPosition));

        return result.toString();
    }

    private int findInsertPosition(StringBuilder remaining) {
        for (int i = remaining.length() - 1; i >= 0; i--) {
            if (remaining.charAt(i) == '0') {
                return i + 1;
            }
        }
        return 0; // 모든 문자가 '1'인 경우
    }

    public static void main(String[] args) {
        Solution105 sol = new Solution105();

        String[] s = {"1110", "100111100", "0111111010"};

        System.out.println(Arrays.toString(sol.solution(s))); // ["1101", "100110110", "0110110111"]
    }
    
}
