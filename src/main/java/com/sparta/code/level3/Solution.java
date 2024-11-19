package com.sparta.code.level3;

import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] result = new int[n];
        int baseValue = s / n;
        int remainder = s % n;
        
        Arrays.fill(result, baseValue);
        for (int i = 0; i < remainder; i++) {
            result[i]++;
        }
        
        Arrays.sort(result);
        
        return result;
    }
    
}
