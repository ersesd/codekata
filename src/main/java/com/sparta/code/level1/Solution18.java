package com.sparta.code.level1;

class Solution18 {
    
    public int[] solution(int brown, int yellow) {
        
        int totalTiles = brown + yellow;
        
        for (int height = 3; height <= Math.sqrt(totalTiles); height++) {
            if (totalTiles % height == 0) {
                int width = totalTiles / height;
                
                int boundary = (width + height - 2) * 2;
                int center = totalTiles - boundary;
                
                if (brown == boundary && yellow == center) {
                    return new int[] {width, height};
                }
            }
        }
        
        return null;
        
    }
    
}
