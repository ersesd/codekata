package com.sparta.code.level1;

class n28 {
    
    public int solution(int[][] dots) {
        // 네 개의 점에서 가능한 두 직선을 모두 만들어 기울기를 비교
        if (getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])) return 1;
        if (getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3])) return 1;
        if (getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])) return 1;
        
        return 0;
    }

    private double getSlope(int[] p1, int[] p2) {
        return (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
    
}
