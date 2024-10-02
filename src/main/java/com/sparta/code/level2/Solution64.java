package com.sparta.code.level2;

class Solution64 {
    
    public int[] solution(int n) {
        int row = -1;
        int col = 0;
        int num = 1;
        int[][] tri = new int[n][n];
        int[] answer = new int[n * (n + 1) / 2];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    row++;
                } else if (i % 3 == 1) {
                    col++;
                } else if (i % 3 == 2) {
                    row--;
                    col--;
                }
                tri[row][col] = num++;
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = tri[i][j];
            }
        }
        return answer;
    }
    
}
