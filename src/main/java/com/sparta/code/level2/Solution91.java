package com.sparta.code.level2;

class Solution91 {
    
    private int count;

    public int solution(int n) {
        count = 0;
        int[] queens = new int[n]; // 각 행의 퀸 위치를 저장하는 배열
        placeQueens(queens, 0, n);
        return count;
    }

    private void placeQueens(int[] queens, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                placeQueens(queens, row + 1, n);
            }
        }
    }

    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution91 sol = new Solution91();

        System.out.println(sol.solution(4)); // 2
        System.out.println(sol.solution(8)); // 92
        System.out.println(sol.solution(12)); // 14200
    }
    
}
