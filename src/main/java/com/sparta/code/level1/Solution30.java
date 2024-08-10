package com.sparta.code.level1;

class Solution30 {
    
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int largerSide = Math.max(sizes[i][0], sizes[i][1]);
            int smallerSide = Math.min(sizes[i][0], sizes[i][1]);
            
            maxW = Math.max(maxW, largerSide);
            maxH = Math.max(maxH, smallerSide);
        }
        return maxW * maxH;
    }
    
}
