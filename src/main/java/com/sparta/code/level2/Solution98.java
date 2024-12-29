package com.sparta.code.level2;

import java.util.*;

class Solution98 {
    public long solution(String expression) {
        // 가능한 연산자 우선순위 조합
        String[] operators = {"+-*", "+*-", "-*+", "-+*", "*+-", "*-+"};
        long maxResult = 0;

        for (String operatorOrder : operators) {
            maxResult = Math.max(maxResult, Math.abs(calculate(expression, operatorOrder)));
        }

        return maxResult;
    }

    private long calculate(String expression, String operatorOrder) {
        // 숫자와 연산자 분리
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(number.toString()));
                number = new StringBuilder();
                operators.add(c);
            } else {
                number.append(c);
            }
        }
        numbers.add(Long.parseLong(number.toString()));

        // 연산자 우선순위에 따라 계산
        for (char op : operatorOrder.toCharArray()) {
            for (int i = 0; i < operators.size(); ) {
                if (operators.get(i) == op) {
                    long result = performOperation(numbers.get(i), numbers.get(i + 1), op);
                    numbers.remove(i + 1);
                    numbers.set(i, result);
                    operators.remove(i);
                } else {
                    i++;
                }
            }
        }

        return numbers.get(0);
    }

    private long performOperation(long a, long b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Solution98 sol = new Solution98();

        // 테스트 케이스
        System.out.println(sol.solution("100-200*300-500+20")); // 60420
        System.out.println(sol.solution("50*6-3*2")); // 300
    }
}