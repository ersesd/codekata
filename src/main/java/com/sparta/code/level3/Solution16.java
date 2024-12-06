package com.sparta.code.level3;

import java.util.*;

class Solution16 {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        // 최단 거리 계산 (BFS 사용)
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        distances[destination] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) { // 방문하지 않은 지역
                    distances[neighbor] = distances[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        // 각 source에 대한 최단 거리 결과 생성
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = distances[sources[i]];
        }
        
        return result;
    }
    
}
