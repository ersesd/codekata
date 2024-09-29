package com.sparta.code.level2;

import java.util.*;

class Solution62 {
    
    public double[] solution(int k, int[][] ranges) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(k);
        
        while (k > 1) {
            k = (k % 2 == 0) ? k / 2 : 3 * k + 1;
            sequence.add(k);
        }
        
        double[] areas = new double[sequence.size() - 1];
        for (int i = 0; i < areas.length; i++) {
            double y1 = sequence.get(i);
            double y2 = sequence.get(i + 1);
            areas[i] = (y1 + y2) / 2; 
        }
        
        double[] prefixSum = new double[areas.length + 1];
        for (int i = 0; i < areas.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + areas[i];
        }
        
        double[] result = new double[ranges.length];
        
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            int endIndex = sequence.size() - 1 + b;
            
            if (a > endIndex) {
                result[i] = -1;
                continue;
            }
            
            double area = prefixSum[endIndex] - prefixSum[a];
            result[i] = area;
        }
        
        return result;
    }
}
