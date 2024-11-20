package com.sparta.code.level2;

class Solution81 {
    
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int totalRemoved = 0;
        boolean hasMatch = true;
        
        while (hasMatch) {
            boolean[][] toRemove = new boolean[m][n];
            hasMatch = false;
            
            // 2x2 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char current = map[i][j];
                    if (current != ' ' && current == map[i][j + 1] && current == map[i + 1][j] && current == map[i + 1][j + 1]) {
                        toRemove[i][j] = toRemove[i][j + 1] = toRemove[i + 1][j] = toRemove[i + 1][j + 1] = true;
                        hasMatch = true;
                    }
                }
            }
            
            // 블록 지우기
            int removedCount = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        map[i][j] = ' ';
                        removedCount++;
                    }
                }
            }
            totalRemoved += removedCount;
            
            // 블록 떨어뜨리기
            for (int j = 0; j < n; j++) {
                int emptyIndex = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != ' ') {
                        map[emptyIndex--][j] = map[i][j];
                    }
                }
                for (int i = emptyIndex; i >= 0; i--) {
                    map[i][j] = ' ';
                }
            }
        }
        
        return totalRemoved;
    }
    
}
