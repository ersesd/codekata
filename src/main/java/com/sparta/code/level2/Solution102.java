package com.sparta.code.level2;

import java.util.*;

class Solution102 {
    
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats); // 돗자리 크기를 오름차순 정렬
        
        int maxSize = -1;

        for (int mat : mats) {
            if (canFit(mat, park)) {
                maxSize = mat;
            } else {
                break; // 더 큰 돗자리는 불가능하므로 탐색 종료
            }
        }

        return maxSize;
    }

    private boolean canFit(int size, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (canPlaceMat(size, park, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canPlaceMat(int size, String[][] park, int row, int col) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution102 sol = new Solution102();

        int[] mats = {5, 3, 2};
        String[][] park = {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        System.out.println(sol.solution(mats, park)); // 3
    }
    
}
