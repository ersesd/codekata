package com.sparta.code.level2;

import java.util.*;

class Solution74 {
    
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();

        // 각 상자를 순회하며 그룹을 형성
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int groupSize = 0;
                int current = i;

                // 이미 방문한 상자를 만날 때까지 그룹 형성
                while (!visited[current]) {
                    visited[current] = true;
                    current = cards[current] - 1;
                    groupSize++;
                }
                groupSizes.add(groupSize);
            }
        }

        // 그룹 크기를 내림차순으로 정렬
        groupSizes.sort(Collections.reverseOrder());

        // 그룹이 두 개 이상일 경우 최대 점수 계산, 그렇지 않으면 0 반환
        if (groupSizes.size() < 2) {
            return 0;
        } else {
            return groupSizes.get(0) * groupSizes.get(1);
        }
    }
    
}
