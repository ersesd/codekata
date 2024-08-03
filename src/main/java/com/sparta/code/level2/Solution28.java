package com.sparta.code.level2;

import java.util.*;

class Solution28 {
    
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        // order 길이 순회
        for (int i = 1; i <= order.length; i++) {
            stack.push(i);
            // 스택의 최상단이 order의 현재 인덱스와 같을 때까지 pop
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            }
        }
        return answer;
    }
    
}
