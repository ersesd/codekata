package com.sparta.code.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution132 {
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        // 각 칸이 속하는 석유 덩어리의 번호를 저장할 배열 (0이면 아직 미할당)
        int[][] comp = new int[n][m];
        // 각 석유 덩어리의 크기를 저장. 덩어리 번호는 1부터 부여합니다.
        // 최대 덩어리 개수는 n*m까지 있을 수 있으므로 n*m+1 크기의 배열 사용
        int[] compSize = new int[n * m + 1];
        
        int compId = 1;  // 석유 덩어리 번호
        
        // 상하좌우 이동을 위한 방향 배열
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // BFS를 이용해 석유(1)가 있는 칸들의 연결 덩어리를 구분합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && comp[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    comp[i][j] = compId;
                    int count = 0;
                    
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        count++;
                        int r = cur[0];
                        int c = cur[1];
                        
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (land[nr][nc] == 1 && comp[nr][nc] == 0) {
                                    comp[nr][nc] = compId;
                                    queue.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    compSize[compId] = count;
                    compId++;
                }
            }
        }
        
        // 각 열에 대해 시추관이 뚫렸을 때 뽑을 수 있는 석유의 총량을 계산합니다.
        int maxOil = 0;
        for (int col = 0; col < m; col++) {
            int sum = 0;
            // 한 열에 같은 석유 덩어리가 여러 칸에 걸쳐 있을 수 있으므로,
            // 해당 열에서 이미 합산한 덩어리는 중복 계산하지 않도록 체크합니다.
            boolean[] used = new boolean[compId];
            for (int row = 0; row < n; row++) {
                if (land[row][col] == 1) {
                    int id = comp[row][col];
                    if (!used[id]) {
                        used[id] = true;
                        sum += compSize[id];
                    }
                }
            }
            maxOil = Math.max(maxOil, sum);
        }
        
        return maxOil;
    }
    
    // 테스트를 위한 main 메서드 (실행 시 결과를 확인할 수 있습니다)
    public static void main(String[] args) {
        Solution132 sol = new Solution132();
        
        int[][] land1 = {
            {0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 1, 1}
        };
        System.out.println(sol.solution(land1)); // 예상 결과: 9
        
        int[][] land2 = {
            {1, 0, 1, 0, 1, 1},
            {1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1}
        };
        System.out.println(sol.solution(land2)); // 예상 결과: 16
    }
    
}
