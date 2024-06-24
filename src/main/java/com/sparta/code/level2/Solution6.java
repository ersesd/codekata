package com.sparta.code.level2;

import java.util.PriorityQueue;

class Solution6 {
    
    public int[] solution(int k, int[] score) {
        
        int[] answer = new int[score.length];
        PriorityQueue<Integer> aware = new PriorityQueue<>();
        
        for (int i = 0; i < score.length; i++) {
            aware.offer(score[i]);
 
            if (aware.size() > k) {
                aware.poll();
            }
 
            answer[i] = aware.peek();
            
        }
 
        return answer;
    }
    
}