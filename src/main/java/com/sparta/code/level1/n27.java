package com.sparta.code.level1;

class n27 {
    
    public int solution(int[][] lines) {
        int[] lineCoverage = new int[201]; // -100 ~ 100을 표현하기 위해 크기를 201로 설정
        
        for (int[] line : lines) {
            int start = line[0] + 100; // -100 ~ 100을 0 ~ 200으로 변환
            int end = line[1] + 100;
            for (int i = start; i < end; i++) {
                lineCoverage[i]++;
            }
        }
        
        int overlappingLength = 0;
        for (int i = 0; i < lineCoverage.length; i++) {
            if (lineCoverage[i] > 1) {
                overlappingLength++;
            }
        }
        
        return overlappingLength;
    }
    
}
