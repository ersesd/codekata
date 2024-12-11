package com.sparta.code.level3;

import java.util.*;

class Solution20 {
    
    public int solution(int[][] scores) {
        // 완호의 점수를 저장
        int[] wanhoScore = scores[0];
        int wanhoSum = wanhoScore[0] + wanhoScore[1];

        // 근무 태도 점수를 기준으로 내림차순, 같은 점수라면 동료 평가 점수를 기준으로 오름차순 정렬
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int maxPeerScore = 0;
        List<int[]> eligibleScores = new ArrayList<>();

        for (int[] score : scores) {
            // 현재 사원이 다른 사원보다 두 점수가 모두 낮은 경우
            if (score[1] < maxPeerScore) {
                if (score == wanhoScore) {
                    return -1; // 완호는 인센티브를 받을 수 없음
                }
            } else {
                maxPeerScore = Math.max(maxPeerScore, score[1]);
                eligibleScores.add(score); // 인센티브를 받을 수 있는 사원 추가
            }
        }

        // 인센티브를 받을 수 있는 사원들을 점수 합 기준으로 정렬
        eligibleScores.sort((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        int rank = 1;
        int prevSum = -1;
        int count = 0; // 같은 점수 합을 가진 사원의 수

        for (int[] score : eligibleScores) {
            int currentSum = score[0] + score[1];

            if (currentSum != prevSum) {
                rank += count; // 동석차 수만큼 석차를 건너뜀
                count = 0;
                prevSum = currentSum;
            }

            count++;

            if (score == wanhoScore) {
                return rank; // 완호의 석차 반환
            }
        }

        return -1; // 기본적으로 여기 도달하지 않음
    }
    
}
