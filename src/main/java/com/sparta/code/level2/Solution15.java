package com.sparta.code.level2;

class Solution15 {
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(0, k, dungeons, visited);
    }

    private int dfs(int count, int fatigue, int[][] dungeons, boolean[] visited) {
        int maxCount = count;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= fatigue) {
                visited[i] = true;
                maxCount = Math.max(maxCount, dfs(count + 1, fatigue - dungeons[i][1], dungeons, visited));
                visited[i] = false;
            }
        }

        return maxCount;
        
    }
    
}
