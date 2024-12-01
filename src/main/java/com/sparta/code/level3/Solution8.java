package com.sparta.code.level3;

import java.util.*;

class Solution8 {
    
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 진출 지점 기준으로 정렬
        
        int cameras = 0;
        int lastCameraPosition = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            if (lastCameraPosition < route[0]) {
                cameras++;
                lastCameraPosition = route[1];
            }
        }
        
        return cameras;
    }
    
}
