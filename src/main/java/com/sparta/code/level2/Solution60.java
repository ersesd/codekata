package com.sparta.code.level2;

import java.util.*;

class Solution60 {
    
    private int answer;
    private boolean[] visited;
    private List<List<Integer>> adjacencyList;

    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            bfs(i, n, wires);
        }
        
        return answer;
    }
    
    private void bfs(int removedIndex, int n, int[][] wires) {
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            if (i == removedIndex) continue;
            int a = wires[i][0] - 1;
            int b = wires[i][1] - 1;
            
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
        
        visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        
        int countVisited = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            countVisited++;
            
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        int countUnvisited = n - countVisited;
        answer = Math.min(answer, Math.abs(countVisited - countUnvisited));
    }
    
}
