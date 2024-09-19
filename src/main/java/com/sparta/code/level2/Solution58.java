package com.sparta.code.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution58 {
    
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for (int weight : weights) {
            double[] ratios = {
                weight * 1.0,
                (weight * 2.0) / 3.0,
                (weight * 1.0) / 2.0,
                (weight * 3.0) / 4.0
            };

            for (double ratio : ratios) {
                answer += map.getOrDefault(ratio, 0);
            }

            map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
        }

        return answer;
    }
    
}
