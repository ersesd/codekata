package com.sparta.code.level2;

import java.util.*;

class Solution35 {
    
    int[] dX = {1, -1, 0, 0};
    int[] dY = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        int answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            return -1;  // 도달할 수 없는 경우
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;  // 시작 위치 방문 표시 및 거리 기록

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];

            for (int i = 0; i < 4; i++) {
                int nX = cX + dX[i];
                int nY = cY + dY[i];

                // 범위를 벗어나거나, 이미 방문했거나, 갈 수 없는 곳이면 무시
                if (nX < 0 || nX >= maps.length || nY < 0 || nY >= maps[0].length) {
                    continue;
                }

                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
            
        }
    }
    
}
