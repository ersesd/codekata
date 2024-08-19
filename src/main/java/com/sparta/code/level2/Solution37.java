package com.sparta.code.level2;

import java.util.*;

class Solution37 {
    
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;
        
        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();
        
        for (int i = 1; i < size; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }
        
        first.add(topping[0]);
        
        for (int i = 1; i < size; i++) {
            first.add(topping[i]);
            second.put(topping[i], second.get(topping[i]) - 1);
            
            if (second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }
            
            if (first.size() == second.size()) {
                answer++;
            }
        }
        
        return answer;
    }
    
}
