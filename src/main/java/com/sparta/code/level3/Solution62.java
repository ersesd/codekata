package com.sparta.code.level3;

import java.util.*;

public class Solution62 {
    
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                // 해당 숫자 삽입: 이미 있으면 count 증가
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else { // "D" 명령
                // 빈 큐이면 무시
                if (map.isEmpty()) continue;
                
                if (num == 1) {
                    // 최댓값 삭제
                    int maxKey = map.lastKey();
                    if (map.get(maxKey) == 1) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                } else if (num == -1) {
                    // 최솟값 삭제
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
        }
        
        // 큐가 비어있으면 [0,0] 반환, 아니면 [최댓값, 최솟값] 반환
        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
    
}
