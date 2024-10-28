package com.sparta.code.level1;

import java.util.HashMap;
import java.util.Map;

class n21 {
    
    public int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // 각 주사위 숫자의 빈도 계산
        for (int num : dice) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 점수 계산
        if (countMap.size() == 1) {
            // 네 주사위 모두 같은 경우
            return 1111 * a;
        } else if (countMap.size() == 2) {
            int p = 0, q = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 3) {
                    // 세 주사위가 같은 경우
                    p = entry.getKey();
                } else if (entry.getValue() == 1) {
                    q = entry.getKey();
                } else {
                    // 두 주사위씩 같은 경우
                    if (p == 0) p = entry.getKey();
                    else q = entry.getKey();
                }
            }
            if (countMap.containsValue(3)) {
                return (int) Math.pow(10 * p + q, 2);
            } else {
                return (p + q) * Math.abs(p - q);
            }
        } else if (countMap.size() == 3) {
            int p = 0, q = 0, r = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 2) {
                    p = entry.getKey();
                } else if (q == 0) {
                    q = entry.getKey();
                } else {
                    r = entry.getKey();
                }
            }
            return q * r;
        } else {
            // 네 주사위가 모두 다른 경우
            int min = Math.min(Math.min(a, b), Math.min(c, d));
            return min;
        }
    }
    
}
