package com.sparta.code.level3;

public class Solution59 {
    
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        // board보다 한 행, 한 열 더 큰 크기의 차분 배열 선언
        int[][] diff = new int[n + 1][m + 1];
        
        // 각 skill 연산을 차분 배열에 반영
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            // type 1: 공격 (내구도 감소), type 2: 회복 (내구도 증가)
            int effect = (type == 1) ? -degree : degree;
            
            diff[r1][c1] += effect;
            if (c2 + 1 < m + 1) {
                diff[r1][c2 + 1] -= effect;
            }
            if (r2 + 1 < n + 1) {
                diff[r2 + 1][c1] -= effect;
            }
            if (r2 + 1 < n + 1 && c2 + 1 < m + 1) {
                diff[r2 + 1][c2 + 1] += effect;
            }
        }
        
        // 행 방향 누적합: 각 행에서 왼쪽부터 오른쪽으로 누적
        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
        // 열 방향 누적합: 각 열에서 위부터 아래로 누적
        for (int j = 0; j < m + 1; j++) {
            for (int i = 1; i < n + 1; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        int answer = 0;
        // 최종 board의 각 칸에 diff 값을 적용하여 내구도가 1 이상인 건물 개수를 센다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + diff[i][j] >= 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
}
