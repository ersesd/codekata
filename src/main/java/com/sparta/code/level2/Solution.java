package com.sparta.code.level2;

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 타겟을 끝나는 지점 기준으로 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        double lastIntercept = -1; // 마지막 요격 미사일 발사 지점

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            // 현재 타겟이 마지막 요격 미사일로 요격 불가능하면 새로운 미사일 발사
            if (lastIntercept < start) {
                lastIntercept = end - 0.5; // 끝나는 지점 바로 전에 요격
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 케이스
        System.out.println(sol.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}})); // 3
        System.out.println(sol.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}})); // 2
        System.out.println(sol.solution(new int[][]{{1, 5}, {2, 6}, {3, 7}, {4, 8}})); // 1
    }
}