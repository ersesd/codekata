package com.sparta.code.level3;

import java.util.*;

class Solution {
    public int solution(int[] a) {
        if (a.length < 2) return 0; // 스타 수열이 될 수 없음

        int[] counts = new int[a.length];
        for (int num : a) {
            counts[num]++;
        }

        int maxLength = 0;

        for (int target = 0; target < counts.length; target++) {
            if (counts[target] == 0) continue; // 해당 숫자가 없으면 넘어감

            int length = 0;

            for (int i = 0; i < a.length - 1; i++) {
                if ((a[i] == target || a[i + 1] == target) && a[i] != a[i + 1]) {
                    length += 2; // 한 쌍 추가
                    i++; // 다음 쌍으로 이동
                }
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {0};
        int[] test2 = {5, 2, 3, 3, 5, 3};
        int[] test3 = {0, 3, 3, 0, 7, 2, 0, 2, 2, 0};

        System.out.println(sol.solution(test1)); // 0
        System.out.println(sol.solution(test2)); // 4
        System.out.println(sol.solution(test3)); // 8
    }
}