package com.sparta.code.level1;

import java.util.HashMap;
import java.util.Map;

class n18 {
    
    public int solution(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int maxFrequency = 0;
        int mode = -1;
        boolean isUnique = true;
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();
            
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = value;
                isUnique = true;
            } else if (frequency == maxFrequency) {
                isUnique = false;
            }
        }
        
        return isUnique ? mode : -1;
    }
    
}
