package com.sparta.code.level3;

public class Solution {
    
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;      // mid 명이 건널 수 있다면 후보 갱신
                left = mid + 1;    // 더 많은 사람이 건널 수 있는지 탐색
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    // 주어진 people 수(즉, mid 명)가 건널 수 있는지 판단하는 함수
    private boolean canCross(int[] stones, int k, int people) {
        int count = 0;
        for (int stone : stones) {
            // stone의 내구도가 people보다 작으면, 이 돌은 해당 인원에 의해 다 사용되어 건널 수 없는 돌이 됨
            if (stone < people) {
                count++;
                if (count >= k) {
                    return false; // 연속된 돌이 k개 이상이면 건널 수 없음
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
    
}
