package com.sparta.code.level1;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 123;
        int result1 = sol.solution(n1);
        System.out.println("N = " + n1 + ", Answer = " + result1);
        int n2 = 987;
        int result2 = sol.solution(n2);
        System.out.println("N = " + n2 + ", Answer = " + result2);
    }
}