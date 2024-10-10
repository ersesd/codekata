package com.sparta.code.level2;

class Solution72 {
    
    public int solution(int[][] board) {
        int maxSide = 0;  // 가장 큰 정사각형의 변 길이

        // 행과 열의 크기
        int rows = board.length;
        int cols = board[0].length;

        // DP 테이블에서 각 위치에서 만들 수 있는 정사각형의 크기를 저장
        int[][] dp = new int[rows][cols];

        // DP 테이블 초기화 및 계산
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // 가장자리 부분은 자기 자신을 최대 정사각형 크기로 가짐
                        dp[i][j] = 1;
                    } else {
                        // 왼쪽, 위, 왼쪽 위 대각선 값 중 최소값 + 1
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    // 가장 큰 변의 길이를 저장
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
    
}
