package com.sparta.code.level2;

import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        int mixCount = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int leastSpicy = pq.poll();
            int secondLeastSpicy = pq.poll();
            int newScoville = leastSpicy + (secondLeastSpicy * 2);
            pq.add(newScoville);
            mixCount++;
        }
        
        return pq.peek() >= K ? mixCount : -1;
    }
    
}
