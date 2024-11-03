package com.sparta.code.level1;

import java.util.*;

class Solution {
    
    public int solution(int[] common) {
        int length = common.length;
        
        // 등차수열 확인
        if (common[1] - common[0] == common[2] - common[1]) {
            int difference = common[1] - common[0];
            return common[length - 1] + difference;
        }
        
        // 등비수열 확인
        int ratio = common[1] / common[0];
        return common[length - 1] * ratio;
    }
    
}
