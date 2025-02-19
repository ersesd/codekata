package com.sparta.code.level3;

public class Solution {
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networkCount++;
                dfs(i, computers, visited, n);
            }
        }
        return networkCount;
    }
    
    private void dfs(int curr, int[][] computers, boolean[] visited, int n) {
        visited[curr] = true;
        for (int j = 0; j < n; j++) {
            if (computers[curr][j] == 1 && !visited[j]) {
                dfs(j, computers, visited, n);
            }
        }
    }
    
}
