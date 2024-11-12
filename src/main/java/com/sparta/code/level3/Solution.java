package com.sparta.code.level3;

import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = 0;
        int bIndex = 0;
        int score = 0;
        
        while (bIndex < B.length) {
            if (B[bIndex] > A[aIndex]) {
                score++;
                aIndex++;
            }
            bIndex++;
        }
        
        return score;
    }
    
}
