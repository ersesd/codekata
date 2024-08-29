package com.sparta.code.level2;

import java.util.*;

public class Solution43 {
    
    public static int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        int[] totalReach = new int[N + 2]; // 각 스테이지에 도달한 사용자 수
        int[] failCount = new int[N + 1]; // 각 스테이지에서 실패한 사용자 수

        // 각 스테이지에 도달한 사용자 수와 실패한 사용자 수 계산
        for (int stage : stages) {
            if (stage <= N) {
                failCount[stage]++;
            }
            for (int i = 1; i <= Math.min(stage, N); i++) {
                totalReach[i]++;
            }
        }

        Map<Integer, Double> failRates = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (totalReach[i] == 0) {
                failRates.put(i, 0.0);
            } else {
                failRates.put(i, (double) failCount[i] / totalReach[i]);
            }
        }

        List<Integer> stageList = new ArrayList<>(failRates.keySet());
        stageList.sort((a, b) -> failRates.get(b).compareTo(failRates.get(a)));

        for (int i = 0; i < N; i++) {
            result[i] = stageList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] stages = {1, 1, 1, 2, 3, 4};
        System.out.println(Arrays.toString(solution(5, stages)));
    }
    
}
