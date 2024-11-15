package com.sparta.code.level3;

import java.util.*;

class Solution5 {
    
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            maxHeap.add(work);
        }
        
        while (n > 0 && !maxHeap.isEmpty()) {
            int maxWork = maxHeap.poll();
            if (maxWork > 0) {
                maxWork--;
                n--;
                maxHeap.add(maxWork);
            }
        }
        
        long overtimeIndex = 0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            overtimeIndex += (long) work * work;
        }
        
        return overtimeIndex;
    }
    
}
