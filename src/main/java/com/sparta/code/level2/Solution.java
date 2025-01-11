package com.sparta.code.level2;

import java.util.*;

class Solution {

    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            Set<Integer> currentSet = dp.get(i);

            String repeatedN = String.valueOf(N).repeat(i);
            currentSet.add(Integer.parseInt(repeatedN));

            for (int j = 1; j < i; j++) {
                Set<Integer> prevSet = dp.get(j);
                Set<Integer> nextSet = dp.get(i - j);

                for (int x : prevSet) {
                    for (int y : nextSet) {
                        currentSet.add(x + y);
                        currentSet.add(x - y);
                        currentSet.add(x * y);
                        if (y != 0) currentSet.add(x / y);
                    }
                }
            }

            if (currentSet.contains(number)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(5, 12)); // 4
        System.out.println(sol.solution(2, 11)); // 3
    }

}