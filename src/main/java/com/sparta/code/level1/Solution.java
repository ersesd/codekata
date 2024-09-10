package com.sparta.code.level1;

import java.util.HashSet;

class Solution {
    
    public int solution(int[] nums) {
        int len = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();

        // 중복되지 않은 폰켓몬을 set에 추가
        for (int num : nums) {
            set.add(num);
        }

        // 비교하여 더 작은 값 반환
        return Math.min(set.size(), len);
    }
    
}
