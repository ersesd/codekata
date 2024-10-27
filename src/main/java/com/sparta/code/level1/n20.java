package com.sparta.code.level1;

class n20 {
    
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] dangerZone = new boolean[n][n];

        // 지뢰가 있는 위치의 주변을 위험 지역으로 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    markDangerZone(dangerZone, i, j, n);
                }
            }
        }

        // 안전한 지역의 수를 계산
        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!dangerZone[i][j]) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }

    // 지뢰 주변을 위험지역으로 표시하는 메서드
    private void markDangerZone(boolean[][] dangerZone, int x, int y, int n) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        dangerZone[x][y] = true; // 지뢰 위치 자체도 위험 지역
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                dangerZone[nx][ny] = true;
            }
        }
    }
    
}
